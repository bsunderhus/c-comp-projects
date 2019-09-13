var margin = {
    top: 20,
    right: 120,
    bottom: 20,
    left: 120
},
width = 960 - margin.right - margin.left,
height = 800 - margin.top - margin.bottom;

var root = {"name":"algoritmo","children":[{"name":"declaracao_algoritmo","children":[{"name":"algoritmo"},{"name":"teste"},{"name":";"}]},{"name":"stm_block","children":[{"name":"inicio"},{"name":"stm_list","children":[{"name":"stm_attr","children":[{"name":"lvalue","children":[{"name":"x"}]},{"name":":="},{"name":"expr","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"42"}]}]}]},{"name":"+"},{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"3"}]}]}]}]},{"name":";"}]}]},{"name":"stm_list","children":[{"name":"stm_attr","children":[{"name":"lvalue","children":[{"name":"f"}]},{"name":":="},{"name":"expr","children":[{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"0"}]}]}]},{"name":"<="},{"name":"expr","children":[{"name":"termo","children":[{"name":"literal","children":[{"name":"1"}]}]}]}]},{"name":";"}]}]},{"name":"fim"}]},{"name":"<EOF>"}]};
var i = 0,
    duration = 750

var tree = d3.layout.tree().nodeSize([70, 40]);
var diagonal = d3.svg.diagonal()
    .projection(function (d) {
    return [d.x, d.y];
});

var svg = d3.select("#body").append("svg").attr("width", "99vw").attr("height", "95vh")
    .call(zm = d3.behavior.zoom().scaleExtent([1,3]).on("zoom", redraw)).append("g")
    .attr("transform", "translate(" + 350 + "," + 20 + ")");

//necessary so that zoom knows where to zoom and unzoom from
zm.translate([350, 20]);

root.x0 = 0;
root.y0 = height / 2;

function collapse(d) {
    if (d.children) {
        d._children = d.children;
        d._children.forEach(collapse);
        d.children = null;
    }
}

//root.children.forEach(collapse);
update(root);

d3.select("#body").style("height", "95vh");

function update(source) {

    // Compute the new tree layout.
    var nodes = tree.nodes(root).reverse(),
        links = tree.links(nodes);

    // Normalize for fixed-depth.
    nodes.forEach(function (d) {
        d.y = d.depth * 180;
    });

    // Update the nodes…
    var node = svg.selectAll("g.node")
        .data(nodes, function (d) {
        return d.id || (d.id = ++i);
    });

    // Enter any new nodes at the parent's previous position.
    var nodeEnter = node.enter().append("g")
        .attr("class", "node")
        .attr("transform", function (d) {
        return "translate(" + source.x0 + "," + source.y0 + ")";
    }).on("click", click);


    nodeEnter.append("text")
        .attr("x", 0)
        .attr("y", 0)
        .attr("dy", 0)
        .attr("text-anchor", "middle")
        .text(function (d) {
        return d.name;
    });

    // Transition nodes to their new position.
    var nodeUpdate = node.transition()
        .duration(duration)
        .attr("transform", function (d) {
        return "translate(" + d.x + "," + d.y + ")";
    });


    nodeUpdate.select("text")
        .style("fill-opacity", 1)
        .style("fill", function (d) {
        return d._children ? "lightsteelblue" : "black";
    });

    // Transition exiting nodes to the parent's new position.
    var nodeExit = node.exit().transition()
        .duration(duration)
        .attr("transform", function (d) {
        return "translate(" + source.x + "," + source.y + ")";
    })
        .remove();

    nodeExit.select("rect")
        .attr("width", 0)
        .attr("height", 0)
    //.attr("width", bbox.getBBox().width)""
    //.attr("height", bbox.getBBox().height)
    .attr("stroke", "black")
        .attr("stroke-width", 1);

    nodeExit.select("text");

    // Update the links…
    var link = svg.selectAll("path.link")
        .data(links, function (d) {
        return d.target.id;
    });

    // Enter any new links at the parent's previous position.
    link.enter().insert("path", "g")
        .attr("class", "link")
        .attr("x", 0)
        .attr("y", 0)
        .attr("d", function (d) {
        var o = {
            x: source.x0,
            y: source.y0
        };
        return diagonal({
            source: o,
            target: o
        });
    });

    // Transition links to their new position.
    link.transition()
        .duration(duration)
        .attr("d", diagonal);

    // Transition exiting nodes to the parent's new position.
    link.exit().transition()
        .duration(duration)
        .attr("d", function (d) {
        var o = {
            x: source.x,
            y: source.y
        };
        return diagonal({
            source: o,
            target: o
        });
    })
        .remove();

    // Stash the old positions for transition.
    nodes.forEach(function (d) {
        d.x0 = d.x;
        d.y0 = d.y;
    });
}

// Toggle children on click.
function click(d) {
    if (d.children) {
        d._children = d.children;
        d.children = null;
    } else {
        d.children = d._children;
        d._children = null;
    }
    update(d);
}

//Redraw for zoom
function redraw() {
  //console.log("here", d3.event.translate, d3.event.scale);
  svg.attr("transform",
      "translate(" + d3.event.translate + ")"
      + " scale(" + d3.event.scale + ")");
}
