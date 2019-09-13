/** Define um TAD representando um mapa de bits.
 * @file bitmap.h
 * @author Joao Paulo Andrade Almeida (jpalmeida@inf.ufes.br)
 */

#ifndef BITMAP_H_
#define BITMAP_H_

/**
 * Estrutura para representar um mapa de bits.
 */
typedef struct {
	unsigned int max_size;		///< tamanho maximo em bits
	unsigned int length; 		///< tamanho atual em bits
	unsigned char* contents; 	///< conteudo do mapa de bits
} bitmap;

unsigned char* bitmapGetContents(bitmap bm);
unsigned int bitmapGetMaxSize(bitmap bm);
unsigned int bitmapGetLength(bitmap bm);
bitmap bitmapInit(unsigned int max_size);
unsigned char bitmapGetBit(bitmap bm, unsigned int index);
void bitmapSetBit(bitmap* bm, unsigned int index, unsigned char bit);
void bitmapAppendLeastSignificantBit(bitmap* bm, unsigned char bit);

#endif /*BITMAP_H_*/
