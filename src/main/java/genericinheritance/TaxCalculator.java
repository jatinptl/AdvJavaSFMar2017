package genericinheritance;

import java.util.List;

public class TaxCalculator {

    public static void calculateTaxes(Taxable t) {
        
    }
    
    public static void batchCalculateTaxes(List<? extends Taxable> it) {
        for (Taxable t : it) {
            calculateTaxes(t);
        }
        Taxable t = null;
//        it.add(t);
    }
    
    public static void collectNewCustomers(List<? super Taxable> lc) {
        Taxable t = null;
        lc.add(t);
//        t = lc.get(0);
    }
    
    public static void main(String[] args) {
        Taxable t = null;
        calculateTaxes(t);
        Individual i = null;
        calculateTaxes(i);
        
        List<Taxable> lt = null;
        batchCalculateTaxes(lt);
        
        List<Individual> li = null;
        batchCalculateTaxes(li);
        
        List<Object> lo = null;
        collectNewCustomers(lo);
        collectNewCustomers(lt);
//        collectNewCustomers(li);
        
    }
}
