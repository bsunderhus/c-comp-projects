import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.io.PrintWriter;

public class CustomListener extends GrammarBaseListener {
    private ArrayList<Object> ctxList = new ArrayList<>();
    private PrintWriter writer;
    
    public CustomListener(PrintWriter writer){
        //get the writer as output.
        this.writer = writer;
    }
    
    //function to be called in each rule entered by the walker.
    @Override 
    public void enterEveryRule(ParserRuleContext ctx) {
        //if ctx is the root
        if(ctx.getParent() == null){
            ctxList.add(ctx);
            writer.println("digraph {");
            writer.println("node0 [label=\"algoritmo\"];");
        }
        int childCount = ctx.getChildCount();
        for(int i = 0 ; i < childCount ; i++){
            ParseTree child = ctx.getChild(i);
            ctxList.add(child);
            //if child is not a leaf
            if(child.getChildCount() != 0){
                RuleContext childCtx = (RuleContext) child.getPayload();
                writer.println("node"+ 
                    ctxList.indexOf(child)+
                    " [label=\""+
                    GrammarParser.ruleNames[childCtx.getRuleIndex()]+
                    "\"];");
            }
            //if child is a leaf
            else{
                writer.println("node"+
                    ctxList.indexOf(child)+
                    " [label=\""+
                    child.getText().replace("\"", "\\\"")+
                    "\"];");
            }
            writer.println("node"+
                ctxList.indexOf(ctx)+
                " -> "+
                "node"+
                ctxList.indexOf(child)+
                ";");
        }
    }
    
    @Override public void exitAlgoritmo(GrammarParser.AlgoritmoContext ctx) {
        writer.println("}");
    }
}