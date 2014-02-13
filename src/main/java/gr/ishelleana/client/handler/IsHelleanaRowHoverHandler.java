package gr.ishelleana.client.handler;

import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.RowHoverEvent;
import com.smartgwt.client.widgets.grid.events.RowHoverHandler;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;

/**
 *
 * @author pgouvas
 */
public class IsHelleanaRowHoverHandler implements RowHoverHandler{

             @Override
            public void onRowHover(RowHoverEvent event)
            {
                ListGridRecord lgr = event.getRecord();                
                if(lgr instanceof TreeNode) {
                    Object object= event.getSource();
                    if (object instanceof TreeGrid){
                        ((TreeGrid)object).setPrompt("info");
                    }
                } else {
                    SC.say("Hovered ListGridRecord is not a tree node");                            
                }
            }
    
}
