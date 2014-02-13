package gr.ishelleana.client.tree;

import com.smartgwt.client.widgets.tree.TreeNode;

/**
 *
 * @author Panagiotis Gouvas
 */
    public  class HierarchicalTreeNode extends TreeNode {  
        
        public HierarchicalTreeNode(String Id, String fatherid, String name) {  
            setAttribute("NodeId", Id);  
            setAttribute("FatherId", fatherid);  
            setAttribute("Name", name);    
        }//Constructor 1          
        
        public HierarchicalTreeNode(String Id, String fatherid, String name, String description) {  
            setAttribute("NodeId", Id);  
            setAttribute("FatherId", fatherid);  
            setAttribute("Name", name);    
            setAttribute("Description", description);
        }//Constructor 2          
        
        public HierarchicalTreeNode(String Id, String fatherid, String name, String description,String icon) {  
            setAttribute("NodeId", Id);  
            setAttribute("FatherId", fatherid);  
            setAttribute("Name", name);    
            setAttribute("Description", description);
            setAttribute("Image", icon);
        }//Constructor 2          
        
        public HierarchicalTreeNode(String Id, String fatherid, String name, boolean isopen) {  
            setAttribute("NodeId", Id);  
            setAttribute("FatherId", fatherid);  
            setAttribute("Name", name);    
            setAttribute("IsOpen", isopen);
        }//Constructor 2  
    }  //EoClass EmployeeTreeNode       