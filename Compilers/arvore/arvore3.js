var treeData ={"name":"algoritmo","children":[{"name":"declaracao_algoritmo","children":[{"name":"algoritmo"},{"name":"idade"},{"name":";"}]},{"name":"var_decl_block","children":[{"name":"variaveis"},{"name":"var_decl","children":[{"name":"idade"},{"name":":"},{"name":"tp_primitivo","children":[{"name":"inteiro"}]}]},{"name":";"},{"name":"var_decl","children":[{"name":"nome"},{"name":":"},{"name":"tp_primitivo","children":[{"name":"literal"}]}]},{"name":";"},{"name":"fim_variaveis"}]},{"name":"stm_block","children":[{"name":"inicio"},{"name":"stm_list","children":[{"name":"fcall","children":[{"name":"imprima"},{"name":"("},{"name":"fargs","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"\"Digite seu nome:\""}]}]}]}]},{"name":")"}]},{"name":";"}]},{"name":"stm_list","children":[{"name":"stm_attr","children":[{"name":"lvalue","children":[{"name":"nome"}]},{"name":":="},{"name":"expr","children":[{"name":"termo","children":[{"name":"fcall","children":[{"name":"leia"},{"name":"("},{"name":")"}]}]}]},{"name":";"}]}]},{"name":"stm_list","children":[{"name":"fcall","children":[{"name":"imprima"},{"name":"("},{"name":"fargs","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"lvalue","children":[{"name":"nome"}]}]}]},{"name":","},{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"\", digite sua idade:\""}]}]}]}]},{"name":")"}]},{"name":";"}]},{"name":"stm_list","children":[{"name":"stm_attr","children":[{"name":"lvalue","children":[{"name":"idade"}]},{"name":":="},{"name":"expr","children":[{"name":"termo","children":[{"name":"fcall","children":[{"name":"leia"},{"name":"("},{"name":")"}]}]}]},{"name":";"}]}]},{"name":"stm_list","children":[{"name":"stm_se","children":[{"name":"se"},{"name":"expr","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"lvalue","children":[{"name":"idade"}]}]}]},{"name":">="},{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"18"}]}]}]}]},{"name":"entao"},{"name":"stm_list","children":[{"name":"stm_se","children":[{"name":"se"},{"name":"expr","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"lvalue","children":[{"name":"idade"}]}]}]},{"name":"<"},{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"60"}]}]}]}]},{"name":"entao"},{"name":"stm_list","children":[{"name":"fcall","children":[{"name":"imprima"},{"name":"("},{"name":"fargs","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"\"adulto!\""}]}]}]}]},{"name":")"}]},{"name":";"}]},{"name":"senao"},{"name":"stm_list","children":[{"name":"fcall","children":[{"name":"imprima"},{"name":"("},{"name":"fargs","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"\"ancião\""}]}]}]},{"name":","},{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"'!'"}]}]}]}]},{"name":")"}]},{"name":";"}]},{"name":"fim_se"}]}]},{"name":"senao"},{"name":"stm_list","children":[{"name":"fcall","children":[{"name":"imprima"},{"name":"("},{"name":"fargs","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"\"menor\""}]}]}]},{"name":","},{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"\"!\""}]}]}]}]},{"name":")"}]},{"name":";"}]},{"name":"fim_se"}]}]},{"name":"fim"}]},{"name":"<EOF>"}]};
// ************** Generate the tree diagram	 *****************
var margin = {top: 40, right: 120, bottom: 20, left: 120},
	width = 960 - margin.right - margin.left,
	height = 500 - margin.top - margin.bottom;

var i = 0;

var tree = d3.layout.tree()

var diagonal = d3.svg.diagonal().projection(function(d) { return [d.x, d.y]; });

var svg = d3.select("body").append("svg")
  .append("g")
	.attr("transform", "translate(" + 0 + "," + margin.top + ")");

root = treeData;

update(root);

function update(source) {
	tree.size([tree.nodes(root).length*30, width]);
	//tree.nodeSize([30,width]);
  // Compute the new tree layout.
  var nodes = tree.nodes(root).reverse(),
	  links = tree.links(nodes);

  // Normalize for fixed-depth.
  nodes.forEach(function(d) { d.y = d.depth * 100; });

  // Declare the nodes…
  var node = svg.selectAll("g.node")
	  .data(nodes, function(d) { return d.id || (d.id = ++i); });

  // Enter the nodes.
  var nodeEnter = node.enter().append("g")
	  .attr("class", "node")
	  .attr("transform", function(d) {
		  return "translate(" + d.x + "," + d.y + ")"; });

  nodeEnter.append("circle")
	  .attr("r", 10)
	  .style("fill", "#fff");

  nodeEnter.append("text")
	  .attr("y", function(d) {
		  return d.children || d._children ? -18 : 18; })
	  .attr("dy", ".35em")
	  .attr("text-anchor", "middle")
	  .text(function(d) { return d.name; })
	  .style("fill-opacity", 1);

  // Declare the links…
  var link = svg.selectAll("path.link")
	  .data(links, function(d) { return d.target.id; });

  // Enter the links.
  link.enter().insert("path", "g")
	  .attr("class", "link")
	  .attr("d", diagonal);


}

var gege = $("g")[0].getBoundingClientRect();
$("svg").height(gege.height + margin.bottom);
$("svg").width(gege.width + margin.right);
