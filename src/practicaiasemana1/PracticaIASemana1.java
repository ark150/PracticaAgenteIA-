/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaiasemana1;

/**
 *
 * @author luda1
 */
public class PracticaIASemana1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mundo mundo1= new Mundo();
        mundo1.llenar();
        mundo1.colocarAgente();
        mundo1.sensar();
        mundo1.imprimir();
//        for (int i = 0; i < 10; i++) {
//            mundo1.sensar();
//            mundo1.mover(mundo1.decidirMovimiento());
//        }
        mundo1.run();
    }
    
}
