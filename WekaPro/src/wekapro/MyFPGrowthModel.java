/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import weka.associations.FPGrowth;
import weka.core.Instances;

/**
 *
 * @author vuhuy
 */
public class MyFPGrowthModel extends MyKnowledgeModel{
    Instances newData ;
    FPGrowth fp;

    public MyFPGrowthModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
        this.fp = new FPGrowth();
    }
    
    public void mineAssociationRules() throws Exception{
        this.newData = removeData(this.dataset);
        fp.setOptions(this.model_options);
        fp.buildAssociations(this.newData);
        
    }

    @Override
    public String toString() {
        return fp.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
