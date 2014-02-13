package gr.ishelleana.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.core.KeyIdentifier;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.SelectionAppearance;
import com.smartgwt.client.types.TreeModelType;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.util.KeyCallback;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.widgets.form.DynamicForm;  
import com.smartgwt.client.widgets.form.fields.CheckboxItem;  
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;  
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;  
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import gr.ishelleana.client.customizer.IsHelleanaHoverCustomizer;
import gr.ishelleana.client.handler.IsHelleanaRowHoverHandler;
import gr.ishelleana.client.tree.HierarchicalTreeNode;

/**
 *
 * @author pgouvas
 */
public class IsHelleanaSearch implements EntryPoint {

    //σκηνές
    public static final TreeNode[] sceneData = new TreeNode[] {  
            new HierarchicalTreeNode("2", "1", "Τύπος Σκηνής", true),  
            new HierarchicalTreeNode("30", "2", "Δράσης", true),  
            new HierarchicalTreeNode("40", "2", "Τρόμου", true),  
            new HierarchicalTreeNode("50", "2", "Ρομαντική", true),  
            new HierarchicalTreeNode("301", "30", "Καταδίωξη", true),
            new HierarchicalTreeNode("302", "30", "Ληστεία", true)            
    };      
    
    //πλάνα
    public static final TreeNode[] planοData = new TreeNode[] {  
            new HierarchicalTreeNode("2", "1", "Είδος Πλάνου", "Το πλάνο είναι η πιο μικρή ενότητα ενός φίλμ που η διάρκειά του ποικίλει."),  
            new HierarchicalTreeNode("11", "2", "Πολύ γενικό πλάνο", "Συνολική εικόνα του ντεκόρ, φυσικού ή τεχνητού, με ή χωρίς ανθρώπους.","images/plan1.gif"),  
            new HierarchicalTreeNode("12", "2", "Γενικό πλάνο", "Πιο σφιχτό από το Πολύ Γενικό. Eίναι ορατή η παρουσία ομάδων ανθρώπων.","images/plan2.gif"),  
            new HierarchicalTreeNode("13", "2", "Μεσαίο πλάνο", "Τα άτομα καδράρονται ολόκληρα. Είναι πλέον ορατές λεπτομέρειες του ντεκόρ.","images/plan3.jpg"),  
            new HierarchicalTreeNode("14", "2", "Αμερικάνικο πλάνο.", "Οι άνθρωποι καδράρονται από το κεφάλι ως τα γόνατα. Προέρχεται κυρίως από τα φίλμ γουέστερν όπου το όριο ήταν το ρεβόλβερ στο μηρό.","images/plan4.jpg"),
            new HierarchicalTreeNode("15", "2", "Κοντινό πλάνο (ραπροσέ)", "Καδράρισμα στο μέσο του στήθους.","images/plan5.jpg"), 
            new HierarchicalTreeNode("16", "2", "Γκρό πλάνο", "Καδράρισμα στο κεφάλι του ανθρώπου (είναι ορατοί και οι ώμοι) ή σε ένα τμήμα του σώματος.","images/plan6.jpg"),
            new HierarchicalTreeNode("17", "2", "Πολύ γκρό πλάνο", "Αξιοποιεί ένα μικρό αντικείμενο ή μια λεπτομέρεια.","images/plan7.jpg")            
    };       
    
    //Γωνία λήψης
    public static final TreeNode[] cameraData = new TreeNode[] {  
            new HierarchicalTreeNode("2", "1", "Γωνία Λήψης και Καδράρισμα", "Η Γωνία Λήψης προσδιορίζεται από τη θέση της κάμερας σε σχέση με τη θέση του αντικειμένου που κινηματογραφούμε. Η γωνία λήψης αλλάζει είτε μετακινώντας τη μηχανή είτε αλλάζοντας φακό."),  
            new HierarchicalTreeNode("11", "2", "Κανονική Γωνία", "Η μηχανή στο ύψος του ανθρώπου."),  
            new HierarchicalTreeNode("12", "2", "Πλονζε", "Η κάμερα από ψηλά σκοπεύει προς τα κάτω. Κυριαρχεί στο αντικείμενο. Επιλέγεται για να αποδοθούν συναισθήματα απομόνωσης, συντριβής, λύπης, απόγνωσης κλπ.","images/camera2.jpg"),  
            new HierarchicalTreeNode("13", "2", "Κοντρ Πλονζε", "Η κάμερα στο έδαφος σκοπεύει προς τα πάνω. Δίνει μια αίσθηση μεγαλείου, τονίζει τη δύναμη, την ισχύ, το θρίαμβο κλπ","images/camera3.jpg"),  
            new HierarchicalTreeNode("14", "2", "Λοξη Γωνία", "Αποδίδει την αστάθεια, μια μεγάλη ένταση κλπ.","images/camera4.gif"),
            new HierarchicalTreeNode("15", "2", "Υποκειμενικό Πλάνο", "Ο θεατής, μέσω της κάμερας, βλέπει με τα μάτια του ηθοποιού."), 
    };       
    
    
    public void onModuleLoad() {
        KeyIdentifier debugKey = new KeyIdentifier();
        debugKey.setCtrlKey(true);
        debugKey.setKeyName("D");

        Page.registerKey(debugKey, new KeyCallback() {
            public void execute(String keyName) {
                SC.showConsole();
            }
        });
        //renderTree
        renderUI();
    } //onModuleLoad
    
    
    private void renderUI(){  
        
        IsHelleanaHoverCustomizer ishelleanacustomizer = new IsHelleanaHoverCustomizer();
        IsHelleanaRowHoverHandler ishelleanarowhoverhandler = new IsHelleanaRowHoverHandler();
        //Scenes
        Tree scenesTree = new Tree();  
        scenesTree.setModelType(TreeModelType.PARENT);  
        scenesTree.setRootValue(1);  
        scenesTree.setNameProperty("Name");  
        scenesTree.setIdField("NodeId");  
        scenesTree.setParentIdField("FatherId"); 
        scenesTree.setOpenProperty("IsOpen");   
        scenesTree.setData(sceneData);  
  
        final TreeGrid sceneTreeGrid = new TreeGrid();  
        sceneTreeGrid.setData(scenesTree);  //load data
        sceneTreeGrid.setShowHeader(Boolean.FALSE);
        //sceneTreeGrid.setWidth(240);  
        //sceneTreeGrid.setHeight(150);  
        sceneTreeGrid.setNodeIcon("icons/16/mpompina.png");  
        sceneTreeGrid.setFolderIcon("icons/16/mpompina.png");  
        sceneTreeGrid.setShowOpenIcons(false);  
        sceneTreeGrid.setShowDropIcons(false);  
        sceneTreeGrid.setClosedIconSuffix("");          
        sceneTreeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);  
        sceneTreeGrid.setShowSelectedStyle(false);  
        sceneTreeGrid.setShowPartialSelection(true);  
        sceneTreeGrid.setCascadeSelection(true);    
        sceneTreeGrid.addDrawHandler(new DrawHandler() {  
            public void onDraw(DrawEvent event) {  
                sceneTreeGrid.getTree().openAll();  
            }  
        });  
        
        
        //Plano
        Tree planoTree = new Tree();  
        planoTree.setModelType(TreeModelType.PARENT);  
        planoTree.setRootValue(1);  
        planoTree.setNameProperty("Name");  
        planoTree.setIdField("NodeId");  
        planoTree.setParentIdField("FatherId"); 
        planoTree.setOpenProperty("IsOpen");   
        planoTree.setData(planοData);  
  
        final TreeGrid planoTreeGrid = new TreeGrid();  
        planoTreeGrid.setData(planoTree);  //load data
        planoTreeGrid.setShowHeader(Boolean.FALSE);
        //planoTreeGrid.setWidth(240);  
        //planoTreeGrid.setHeight(150);  
        planoTreeGrid.setNodeIcon("icons/16/klaketa.png");  
        planoTreeGrid.setFolderIcon("icons/16/klaketa.png");  
        planoTreeGrid.setShowOpenIcons(false);  
        planoTreeGrid.setShowDropIcons(false);  
        planoTreeGrid.setClosedIconSuffix("");          
        planoTreeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);  
        planoTreeGrid.setShowSelectedStyle(false);  
        planoTreeGrid.setShowPartialSelection(true);  
        planoTreeGrid.setCascadeSelection(true);    
        planoTreeGrid.addDrawHandler(new DrawHandler() {  
            public void onDraw(DrawEvent event) {  
                planoTreeGrid.getTree().openAll();  
            }  
        });  
        //hovering
        planoTreeGrid.setHoverMoveWithMouse(true);
        planoTreeGrid.setCanHover(true);
        planoTreeGrid.setShowHover(true);
        planoTreeGrid.setHoverOpacity(75);
        //HoverCustomizer
        planoTreeGrid.setHoverCustomizer(ishelleanacustomizer);
        //Hover Handler
        planoTreeGrid.addRowHoverHandler(ishelleanarowhoverhandler);        
        
        
        //Kamera
        Tree kameraTree = new Tree();  
        kameraTree.setModelType(TreeModelType.PARENT);  
        kameraTree.setRootValue(1);  
        kameraTree.setNameProperty("Name");  
        kameraTree.setIdField("NodeId");  
        kameraTree.setParentIdField("FatherId"); 
        kameraTree.setOpenProperty("IsOpen");   
        kameraTree.setData(cameraData);  
  
        final TreeGrid kameraTreeGrid = new TreeGrid();  
        kameraTreeGrid.setData(kameraTree);  //load data
        kameraTreeGrid.setShowHeader(Boolean.FALSE);
        //kameraTreeGrid.setWidth(240);  
        //kameraTreeGrid.setHeight(150);  
        kameraTreeGrid.setNodeIcon("icons/16/camera.png");  
        kameraTreeGrid.setFolderIcon("icons/16/camera.png");  
        kameraTreeGrid.setShowOpenIcons(false);  
        kameraTreeGrid.setShowDropIcons(false);  
        kameraTreeGrid.setClosedIconSuffix("");          
        kameraTreeGrid.setSelectionAppearance(SelectionAppearance.CHECKBOX);  
        kameraTreeGrid.setShowSelectedStyle(false);  
        kameraTreeGrid.setShowPartialSelection(true);  
        kameraTreeGrid.setCascadeSelection(true);    
        kameraTreeGrid.addDrawHandler(new DrawHandler() {  
            public void onDraw(DrawEvent event) {  
                kameraTreeGrid.getTree().openAll();  
            }  
        });  
        //hovering
        kameraTreeGrid.setHoverMoveWithMouse(true);
        kameraTreeGrid.setCanHover(true);
        kameraTreeGrid.setShowHover(true);
        kameraTreeGrid.setHoverOpacity(75);
        //HoverCustomizer
        kameraTreeGrid.setHoverCustomizer(ishelleanacustomizer);
        //Hover Handler
        kameraTreeGrid.addRowHoverHandler(ishelleanarowhoverhandler);                
        
        
        //Dynamic Form
        DynamicForm rithmiseisform = new DynamicForm();  
  
        final CheckboxItem partialSelection = new CheckboxItem("partialSelect", "Να επιτρέπεται Μερική Επιλογή");  
        partialSelection.setDefaultValue(true);  
        partialSelection.addChangeHandler(new ChangeHandler() {  
            public void onChange(ChangeEvent event) {                  
                boolean selected = partialSelection.getValueAsBoolean();  
                //tree1
                sceneTreeGrid.setShowPartialSelection(!selected);  
                sceneTreeGrid.redraw();
                //tree2
                planoTreeGrid.setShowPartialSelection(!selected);  
                planoTreeGrid.redraw();  
                //tree3
                kameraTreeGrid.setShowPartialSelection(!selected);  
                kameraTreeGrid.redraw();                 
            }//onChange  
        });  
  
        rithmiseisform.setFields(partialSelection);         
        
        //Layout Management
        /*VLayout vlayout = new VLayout(5);
        vlayout.addMember(sceneTreeGrid);  
        vlayout.addMember(planoTreeGrid);     
        vlayout.addMember(kameraTreeGrid);        
        vlayout.addMember(df);
        vlayout.draw();*/
        
        final SectionStack sectionStack = new SectionStack();  
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE); 
        //define sections
        SectionStackSection section1 = new SectionStackSection("Τύπος Σκηνής");  
        section1.addItem(sceneTreeGrid);
        section1.setExpanded(true);  
        SectionStackSection section2 = new SectionStackSection("Είδος Πλάνου");  
        section2.addItem(planoTreeGrid);
        section2.setExpanded(true);
        SectionStackSection section3 = new SectionStackSection("Γωνία Λήψης "); 
        section3.addItem(kameraTreeGrid);
        section3.setExpanded(true); 
        SectionStackSection section5 = new SectionStackSection("Ρυθμίσεις"); 
        section5.addItem(rithmiseisform);
        section5.setExpanded(false);         
        //fill sections
        sectionStack.addSection(section1); 
        sectionStack.addSection(section2); 
        sectionStack.addSection(section3); 
        sectionStack.addSection(section5);         
        sectionStack.setShowResizeBar(Boolean.TRUE);
        
        //Main Layout - Vertical 100%
        VLayout mainLayout = new VLayout();  
        mainLayout.setWidth100();  
        mainLayout.setHeight100();          
        //Header - top 20%
        Label headerLabel = new Label();  
        headerLabel.setContents("Listing");  
        headerLabel.setAlign(Alignment.CENTER);  
        headerLabel.setOverflow(Overflow.HIDDEN);  
        headerLabel.setHeight("10%");  
        headerLabel.setWidth100();
        headerLabel.setShowResizeBar(true);
        //Horizontal - height
        HLayout hlayout = new HLayout();  
        hlayout.setHeight("90%");
        //Fill layout
        Label navigationLabel = new Label();  
        navigationLabel.setContents("Navigation");  
        navigationLabel.setAlign(Alignment.CENTER);  
        navigationLabel.setOverflow(Overflow.HIDDEN);  
        navigationLabel.setWidth("20%");  
        navigationLabel.setShowResizeBar(true);
        
        Label detailsLabel = new Label();  
        detailsLabel.setContents("Details");  
        detailsLabel.setAlign(Alignment.CENTER);  
        detailsLabel.setOverflow(Overflow.HIDDEN);  
        detailsLabel.setWidth("80%");  
        
        //hlayout.addMember(navigationLabel);
        hlayout.addMember(sectionStack);
        hlayout.addMember(detailsLabel);
        
        //Add all
        mainLayout.addMember(headerLabel); //header first
        mainLayout.addMember(hlayout);    //horizontal layout
        mainLayout.draw();                          
        
    }//EoM renderUI
    

    
}//EoC