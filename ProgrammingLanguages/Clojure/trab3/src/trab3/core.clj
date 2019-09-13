(ns trab3.core
  (:gen-class)
  (:require [clojure.java.io :as io]))


(defn file
  "Faz a leitura da entrada.txt."
  []
  (with-open [r (io/reader "entrada.txt")]
    (reduce conj [] (line-seq r))))

(defn str-to-num
  "Transforma os valores recebidos em File que s�o tipo String para numero tratavel."
  [str]
  (into [] (map #(read-string %)
                (.split  #" " str))))

(def lista-ponto  (into [] (map str-to-num (file))))

(defn distancia-euclidiana
  "Retorna a distancia euclidiana entre dois pontos."
  [ ponto centroide]
  (Math/pow (reduce + (map #(Math/pow % 2)(map - ponto centroide)))1/2))


(defn menor-ponto
  "Retorna o menor ponto em uma lista de Pontos"
  [lista]
  (let [ soma (map #(reduce + %) lista)
        menor (apply min soma)]
   (nth lista (.indexOf soma menor))))

(defn maior-distancia
  "Retorna o ponto de maior distancia"
  [centroide lista-ponto]
  (let [lista-dist (map distancia-euclidiana lista-ponto (iterate identity centroide))
        maior (apply max lista-dist)
        lista-maiores (filter #(= maior (distancia-euclidiana % centroide)) lista-ponto)]
    (menor-ponto lista-maiores)))

(defn centroide
  "Retorna o centroide do grupo passado"
  [grupos]
  (into [] (map #(/ % (count grupos))(apply map + grupos))))

(defn algoritmo-parte2
  "2.ENQUANTO Grupos se alteram em duas rodadas consecutivas ou não se completou N iterações FAÇA
a.Distribuir os pontos em K grupos de acordo com a distância mais próxima do ponto para os centróides dos grupos (em caso de empate, atribuir o ponto ao grupo do centróide cujas primeiras coordenadas tem menor valor)
b.Recalcular os centróides da nova distribuição de pontos em K grupos"
  ([grupos n]
     (if (= 0 n)
       grupos;apos n iteracoes, retorna-se grupos.
       (let [centroides (map centroide grupos)
             grupos-vazios (into [] (map empty grupos))]
         (algoritmo-parte2 grupos-vazios lista-ponto centroides n))))
  
  ([grupos n velho-centroides]
     (let [novo-centroides (map centroide grupos)
           grupos-vazios (into [] (map empty grupos))]
       (if (= novo-centroides velho-centroides)
         grupos
         (if (= 0 n)
           grupos
           (algoritmo-parte2 grupos-vazios lista-ponto novo-centroides n)))))
  
  ([grupos lista-de-pontos centroides n]
     (if (empty? lista-de-pontos)
      (algoritmo-parte2 grupos (- n 1) centroides)
       (let [ponto (peek lista-de-pontos)
             novo-lista-pontos (pop lista-de-pontos)
             lista-distancia-ponto-centroide (map #(distancia-euclidiana ponto %)centroides)
             centroide-mais-proximo (apply min lista-distancia-ponto-centroide)
             indice-grupo-escolhido (.indexOf lista-distancia-ponto-centroide centroide-mais-proximo)
             grupo-escolhido (nth grupos indice-grupo-escolhido)
             novo-grupo (conj grupo-escolhido ponto)
             remove-velho-grupo (if (= indice-grupo-escolhido 0)
                                       (subvec grupos 1)
                                       (if (= indice-grupo-escolhido (- (count grupos)1))
                                         (pop grupos)
                                         (into [] (concat (subvec grupos 0 indice-grupo-escolhido) (subvec grupos (+ indice-grupo-escolhido 1))))))
             separa-no-indice (split-at indice-grupo-escolhido remove-velho-grupo);usado para insercao no meio
             primeira-parte (into [] (first separa-no-indice));usado
                                        ;para insercao no meio
             segunda-parte (into [] (second separa-no-indice));usado
                                        ;para insercao no meio
             novo-lista-grupos (if (= indice-grupo-escolhido 0)
                                 (into [] (concat (conj [] novo-grupo) remove-velho-grupo))
                                 (if (= indice-grupo-escolhido (- (count grupos)-1))
                                   (into [] (concat  remove-velho-grupo (conj [] novo-grupo)))
                                   (into [] (concat (into [] (concat primeira-parte (conj [] novo-grupo)))segunda-parte))))]
         (recur novo-lista-grupos novo-lista-pontos centroides n)))))


(defn algoritmo
  "1.Selecionar K pontos iniciais como centróides dos grupos
a.Selecionar o ponto cujas coordenadas somadas tem valor mínimo (em caso de empate, selecionar aquela cujas primeiras coordenadas tem menor valor)
b.Selecionar o ponto mais distante do ponto inicial (em caso de empate, selecionar aquele cujas primeiras coordenadas tem menor valor)
c.Selecionar sucessivamente, até completar os K pontos iniciais, o ponto mais distante do centróide do grupo formado pelos pontos selecionados até então (em caso de empate, selecionar aquele cujas primeiras coordenadas tem menor valor)"
  ([lista-de-pontos arg1];chamada inicial da funcao.
     (let [ponto (menor-ponto lista-de-pontos);menor ponto da lista de pontos.
           nova-lista-de-pontos (into [] (remove #(= ponto %) lista-de-pontos))];nova lista de pontos sem o menor ponto
       (algoritmo nova-lista-de-pontos arg1 (conj [](conj [] ponto))(conj [] ponto)));chamada recursiva do algoritmo passando a nova lista de pontos, uma lista de grupos com um unico ponto (o menor ponto) e um grupo contendo o menor ponto (grupo referencia, usado para calculo).
     )
  ([lista-de-pontos arg1 grupos-retorno grupo-referencia];chamada recursiva
     (if (<=  arg1 1)
       (algoritmo-parte2 grupos-retorno (count lista-ponto))
      (let [ponto (maior-distancia (centroide grupo-referencia) lista-de-pontos)
            nova-lista-de-pontos (into [] (remove #(= ponto %) lista-de-pontos))
            novo-grupo-referencia (conj grupo-referencia ponto)
            novo-grupos-retorno (conj grupos-retorno(conj [] ponto))]
        (recur nova-lista-de-pontos (- arg1 1) novo-grupos-retorno novo-grupo-referencia)))))


(defn indexes-of [e coll] (keep-indexed #(if (= e %2) %1) coll))

(defn Escritor
  [arquivo grupo]
  (spit arquivo grupo :append true))

(defn numerador
  [lista-grupos]
  (if (empty? lista-grupos)
    nil
    (let [grupo (first lista-grupos)
          novo-lista-grupos (rest lista-grupos)
          posicoes (map #(map inc (indexes-of % lista-ponto))grupo)
          pontos (sort (flatten (distinct (map #(map inc (indexes-of % lista-ponto))grupo))))]
      (Escritor "saida.txt" (clojure.string/join ", " pontos))
      (Escritor "saida.txt" "\n\n")
      (recur novo-lista-grupos))))

(defn SSE
  ([lista-grupos] (SSE lista-grupos 0))
  ([lista-grupos soma]
     (if (empty? lista-grupos)
       soma
       (let [grupo (peek lista-grupos)
             novo-lista-grupos (pop lista-grupos)]
         (recur novo-lista-grupos (+ soma (reduce + (map #(Math/pow (distancia-euclidiana % (centroide grupo))2)grupo))))))))


(defn -main
  "The main!."
  [& args]
  (def arg1 (if (nil? args)
              0
              (read-string (first args))))
  (spit "saida.txt" nil)
  (spit "result.txt" nil)
  (def lista-grupos (algoritmo lista-ponto arg1))
  (numerador lista-grupos)
  (Escritor "result.txt" (format "%.4f" (SSE lista-grupos)))
  )
