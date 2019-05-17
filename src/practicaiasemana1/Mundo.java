/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaiasemana1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luda1
 */
public class Mundo  implements Runnable{
    private int [][]mundo;
    private Agente ag;
    private int[] arregloS;
    
    public Mundo(){
        this.mundo= new int [13][16];
        this.ag= new Agente();
        this.arregloS= new int[8];
        //this.mundo[0][0]=0;        
    }
    
    public void llenar(){
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 16; j++) {
                this.mundo[i][j]=0;
            }
        }
        for (int j = 0; j < 16; j++) {
            this.mundo[0][j] = 1;
        }
        for (int j = 0; j < 16; j++) {
            this.mundo[12][j] = 1;
        }
        for (int j = 0; j < 12; j++) {
            this.mundo[j][0] = 1;
        }
        for (int j = 0; j < 12; j++) {
            this.mundo[j][15] = 1;
        }
        
        this.mundo[1][14]=1;
        this.mundo[1][13]=1;
        this.mundo[1][12]=1;
        this.mundo[2][14]=1;
        this.mundo[2][13]=1;
        this.mundo[2][12]=1;
        this.mundo[3][14]=1;
        this.mundo[3][13]=1;
        this.mundo[3][12]=1;
        this.mundo[4][14]=1;
        this.mundo[4][13]=1;
        this.mundo[4][12]=1;
        
        this.mundo[8][14]=1;
        this.mundo[8][13]=1;
        this.mundo[8][12]=1;
        this.mundo[9][14]=1;
        this.mundo[9][13]=1;
        this.mundo[9][12]=1;
        this.mundo[10][14]=1;
        this.mundo[10][13]=1;
        this.mundo[10][12]=1;
        this.mundo[11][14]=1;
        this.mundo[11][13]=1;
        this.mundo[11][12]=1;
        
        this.mundo[11][8]=1;
        this.mundo[11][7]=1;
        this.mundo[11][6]=1;
        this.mundo[10][8]=1;
        this.mundo[10][7]=1;
        this.mundo[10][6]=1;
        
        this.mundo[5][3]=1;
        this.mundo[6][3]=1;
        this.mundo[7][3]=1;
        
        this.mundo[5][4]=1;
        this.mundo[6][4]=1;
        this.mundo[7][4]=1;
        
        this.mundo[5][7]=1;
        this.mundo[6][7]=1;
        this.mundo[7][7]=1;
        
        this.mundo[5][8]=1;
        this.mundo[6][8]=1;
        this.mundo[7][8]=1;
        
        this.mundo[5][5]=1;
        this.mundo[5][6]=1;
    }
    
    public void colocarAgente(){
        this.ag.setY((int) (Math.random() * 10) + 1);
        this.ag.setX((int) (Math.random() * 13) + 1);
        //System.out.println("y:"+this.ag.getY()+", x: "+this.ag.getX());
        while(this.mundo[this.ag.getY()][this.ag.getX()]==1){
            this.ag.setY((int) (Math.random() * 10) + 1);
            this.ag.setX((int) (Math.random() * 13) + 1);
        }
//        this.ag.setY(8);
//        this.ag.setX(8);
        this.mundo[this.ag.getY()][this.ag.getX()]=2;
        System.out.println("y:"+this.ag.getY()+", x: "+this.ag.getX());
        
    }
    
    public void sensar(){
        this.arregloS[0]=this.mundo[this.ag.getY()-1][this.ag.getX()-1];
        this.arregloS[1]=this.mundo[this.ag.getY()-1][this.ag.getX()];
        this.arregloS[2]=this.mundo[this.ag.getY()-1][this.ag.getX()+1];
        
        this.arregloS[7]=this.mundo[this.ag.getY()][this.ag.getX()-1];
        this.arregloS[3]=this.mundo[this.ag.getY()][this.ag.getX()+1];
        
        this.arregloS[6]=this.mundo[this.ag.getY()+1][this.ag.getX()-1];
        this.arregloS[5]=this.mundo[this.ag.getY()+1][this.ag.getX()];
        this.arregloS[4]=this.mundo[this.ag.getY()+1][this.ag.getX()+1];
//        System.out.println("kkk");
//        System.out.println(this.mundo[0][0]);
    }
    
    public String decidirMovimiento(){
        boolean x1,x2,x3,x4;
        boolean[] valoresCondicion= new boolean[8];
        for (int i = 0; i < this.arregloS.length; i++) {
            if(this.arregloS[i]==1){
                valoresCondicion[i]=true;
            }else if(this.arregloS[i]==0){
                valoresCondicion[i]=false;
            }
        }
        x1=valoresCondicion[1]||valoresCondicion[2];
        x2=valoresCondicion[3]||valoresCondicion[4];
        x3=valoresCondicion[5]||valoresCondicion[6];
        x4=valoresCondicion[7]||valoresCondicion[0];
        
        System.out.println("condiciones");
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
        System.out.println(x4);
        
        String direccion="";
        
        if(x1==true&&x2==false){
            direccion="este";
        }else if(x2==true&&x3==false){
            direccion="sur";
        }else if(x3==true&&x4==false){
            direccion="oeste";
        }else if(x4==true&&x1==false){
            direccion="norte";
        }else if(x1==false&&x2==false&&x3==false&&x4==false){
            direccion="norte";
        }
        
        
        return direccion;
        
    }
    
    public void mover(String direccion){
        
        
        if(direccion.equals("este")){
            this.mundo[this.ag.getY()][this.ag.getX()]=0;
            this.ag.setY(this.ag.getY());
            this.ag.setX(this.ag.getX()+1);
            this.mundo[this.ag.getY()][this.ag.getX()]=2;
        }else if(direccion.equals("sur")){
            this.mundo[this.ag.getY()][this.ag.getX()]=0;
            this.ag.setY(this.ag.getY()+1);
            this.ag.setX(this.ag.getX());
            this.mundo[this.ag.getY()][this.ag.getX()]=2;
        }else if(direccion.equals("oeste")){
            this.mundo[this.ag.getY()][this.ag.getX()]=0;
            this.ag.setY(this.ag.getY());
            this.ag.setX(this.ag.getX()-1);
            this.mundo[this.ag.getY()][this.ag.getX()]=2;
        }else if(direccion.equals("norte")){
            this.mundo[this.ag.getY()][this.ag.getX()]=0;
            this.ag.setY(this.ag.getY()-1);
            this.ag.setX(this.ag.getX());
            this.mundo[this.ag.getY()][this.ag.getX()]=2;
        }
        //System.out.println("");
        System.out.println(direccion);
        System.out.println("y:"+this.ag.getY()+", x: "+this.ag.getX());
        
//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 16; j++) {
//                System.out.print(this.mundo[i][j]);
//            }
//            System.out.println("");
//        }
        
    }
    
    
    public void imprimir(){
        System.out.println("");
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 16; j++) {
                if(this.mundo[i][j]==1){
                    System.out.print("1");
                }else if(this.mundo[i][j]==0){
                    System.out.print(" ");
                }else if(this.mundo[i][j]==2){
                    System.out.print("2");
                }
                //System.out.print(this.mundo[i][j]);
            }
            System.out.println("");
        }
        System.out.println("vector sensado");
        for (int i = 0; i < arregloS.length; i++) {
            System.out.println("S"+i+": "+this.arregloS[i]);
        }
        System.out.println("");
    }

    @Override
    public void run() {
        while(true){
            this.sensar();
            this.mover(this.decidirMovimiento());
            this.imprimir();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mundo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}


