package gr.ishelleana.client.customizer;

import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.tree.TreeNode;
import gr.ishelleana.client.tree.HierarchicalTreeNode;

/**
 *
 * @author pgouvas
 */
public class IsHelleanaHoverCustomizer extends HoverCustomizer {

	@Override
	public String hoverHTML(Object value, ListGridRecord record, int rowNum, int colNum) {
		if(record instanceof HierarchicalTreeNode) {
			HierarchicalTreeNode hoveredTreeNode = (HierarchicalTreeNode)record;
                        String description = (hoveredTreeNode.getAttribute("Description")==null?"":hoveredTreeNode.getAttribute("Description"));
                        String image = (hoveredTreeNode.getAttribute("Image")==null?"":"<img src='"+hoveredTreeNode.getAttribute("Image")+"'/>");
			return description+"</br>"+image;

		} else
                if(record instanceof TreeNode)
	        {
			TreeNode hoveredTreeNode = (TreeNode)record;
			return "<br>" + hoveredTreeNode.getTitle()+"</br>";
		} else {
			return "";// should not happen
		}
            }
    
}//EoC IsHelleanaHoverCustomizer
