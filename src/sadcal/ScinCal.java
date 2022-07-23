
package sadcal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ScinCal extends JFrame implements ActionListener, KeyListener, MouseListener, WindowListener {
    
    int ButtonWidth=60,
        ButtonHeight=50;
    int x0=10;
    int x1=x0+ButtonWidth+3, 
        x2=x1+ButtonWidth+3,
        x3=x2+ButtonWidth+3,
        x4=x3+ButtonWidth+3,
        x5=x4+ButtonWidth+3,
        x6=x5+ButtonWidth+3,
        x7=x6+ButtonWidth+3,  
        x8=x7+ButtonWidth+3, 
        x9=x8+ButtonWidth+3;  
    int y0=460;
    int y1=y0-ButtonHeight-5,
        y2=y1-ButtonHeight-5,
        y3=y2-ButtonHeight-5,
        y4=y3-ButtonHeight-5,
        y5=y4-ButtonHeight-5,
        y6=y5-ButtonHeight-5,
        y7=y6-ButtonHeight-5,
        y8=y7-ButtonHeight-5,
        y9=y8-ButtonHeight-5;
    
    int shiftCount = 100 , shiftCountCC = 98 ;
    boolean shiftTrue = false;
    String sniceV = "" ;
    int operationCount=0 ;
    String operator = "" , StringconverterComboBox = "" , listconverterComboBoxValue01 = "" , 
            listconverterComboBoxValue02 = "" , valueformulaComboBox = "" , valueformulaComboBoxValue01 = "" ;
    double value1, value2, sum , memorySave;
    
     String stringTFFormulaInputSum ="" , TFF01="" ,TFF02="" ,TFF03="";
         double valTFF0 ,valTFF1 , valTFF2;
         
    public ScinCal() {
        initComponent();
    } 
    void txtFieldStyle(JTextField name, int x) {
        if (x == 1) {
            name.setBackground(Color.BLACK);
            name.setForeground(Color.YELLOW);
            name.setFont(new Font("Tahoma", 1, 18));
            name.setHorizontalAlignment(JTextField.RIGHT);
        } else if (x == 2) {

        }
    }

    void buttonStyle(JButton name , int x) {
        if(x == 1){
            name.setForeground(Color.black);
            name.setBackground(new Color(80,236,236));
            name.setFont(new Font("Times New Roman", 1, 18));  
        }else if(x == 3){
            name.setBackground(Color.BLACK);
            name.setForeground(Color.YELLOW);
            name.setFont(new Font("Times New Roman", 1, 18));  
        }else if(x == 2){
            name.setBackground(new Color(180,50,60));
            name.setFont(new Font("Times New Roman", 1, 18));  
        }else if(x == 4){
            name.setForeground(Color.black);
            name.setBackground(new Color(80,236,236));
            name.setFont(new Font("Times New Roman", 1, 15));
        }else if(x == 6){
            name.setForeground(Color.black);
            name.setBackground(new Color(78,87,63));
            name.setFont(new Font("Times New Roman", 1, 10));
        }else{
            name.setForeground(Color.black);
            name.setBackground(new Color(78,87,63));
            name.setFont(new Font("Times New Roman", 1, 18));
        }
    }

    void lableStyle(JLabel name , int x) {
        if(x == 1){
        name.setBackground(Color.BLACK);
        name.setForeground(Color.YELLOW);
        name.setFont(new Font("Tahoma", 1, 18));
        name.setHorizontalAlignment(JLabel.RIGHT);
        name.setOpaque(true);
        }
    }

    void comboBoxStyle(JComboBox name , int x) {
        if(x == 1){
          name.setForeground(Color.black);
          name.setBackground(new Color(80,236,236));
            name.setFont(new Font("Times New Roman", 1, 18));
         }else if(x == 2){
          name.setForeground(Color.black);
          name.setBackground(new Color(80,236,236));
          name.setFont(new Font("Times New Roman", 1, 15));
         }
    }

    void initComponent() {    // initComponent() start
        //--------------------------------------
        setTitle("Calculator");
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(400, 40, 400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        this.addWindowListener(this);

        //-----------------------------------------
        dis = new JTextField("0");
        dis.setBounds(20, 20, 350, 50);
        txtFieldStyle(dis, 1);
        dis.addKeyListener(this);
        dis.addMouseListener(this);
        add(dis);
        
        plus = new JButton("+");   
            plus.setBounds(x0, y1, ButtonWidth, ButtonHeight); 
                plus.addActionListener(this);  
                    add(plus); 
                        buttonStyle(plus , 5);             
        num00 = new JButton("00"); 
            num00.setBounds(x1, y1, ButtonWidth, ButtonHeight);   
                num00.addActionListener(this);     
                    add(num00);    
                        buttonStyle(num00 , 5);
        num0 = new JButton("0");   
            num0.setBounds(x2, y1, ButtonWidth, ButtonHeight);  
                buttonStyle(num0 , 1);  
                    num0.addActionListener(this);    
                        add(num0);
        dot = new JButton(".");    
            dot.setBounds(x3, y1, ButtonWidth, ButtonHeight);  
                dot.addActionListener(this);      
                    add(dot); 
                        buttonStyle(dot , 5);
        equal = new JButton("="); 
            equal.setBounds(x4 , y1, ButtonWidth * 2,  ButtonHeight); 
                equal.addActionListener(this);       
                    add(equal); 
                        buttonStyle(equal , 5);

        minus = new JButton("-"); 
            minus.setBounds(x0, y2, ButtonWidth, ButtonHeight);
                minus.addActionListener(this);   
                    add(minus);   
                        buttonStyle(minus , 5);
        num1 = new JButton("1");   
            num1.setBounds(x1, y2, ButtonWidth, ButtonHeight); 
                buttonStyle(num1 , 1); 
                    num1.addActionListener(this);  
                        add(num1);
        num2 = new JButton("2");    
            num2.setBounds(x2, y2, ButtonWidth, ButtonHeight); 
                buttonStyle(num2 , 1);
                    num2.addActionListener(this);   
                        add(num2);
        num3 = new JButton("3");   
            num3.setBounds(x3, y2, ButtonWidth, ButtonHeight);  
                buttonStyle(num3 , 1);   
                    num3.addActionListener(this);  
                        add(num3);
        cruelty = new JButton("x!");   
            cruelty.setBounds(x4, y2, ButtonWidth , ButtonHeight); 
                cruelty.addActionListener(this);   
                    add(cruelty);  
                        buttonStyle(cruelty , 5);
        exponant = new JButton("<html>10<sup>x</sup></html>");  
            exponant.setBounds(x5, y2, ButtonWidth , ButtonHeight);   
                exponant.addActionListener(this);   
                    add(exponant); 
                        buttonStyle(exponant , 5);
            
        multy = new JButton("*");  
            multy.setBounds(x0, y3, ButtonWidth, ButtonHeight); 
                multy.addActionListener(this);
                    add(multy);    
                        buttonStyle(multy , 5);
        num4 = new JButton("4");  
            num4.setBounds(x1, y3, ButtonWidth, ButtonHeight); 
                buttonStyle(num4 , 1);  
                    num4.addActionListener(this);   
                        add(num4);
        num5 = new JButton("5");   
            num5.setBounds(x2, y3, ButtonWidth, ButtonHeight); 
                buttonStyle(num5 , 1);  
                    num5.addActionListener(this);  
                     add(num5);
        num6 = new JButton("6");  
            num6.setBounds(x3, y3, ButtonWidth, ButtonHeight);
                buttonStyle(num6 , 1);  
                    num6.addActionListener(this); 
                        add(num6);

        divi = new JButton("/"); 
            divi.setBounds(x0, y4, ButtonWidth, ButtonHeight); 
                divi.addActionListener(this); 
                    add(divi); 
                        buttonStyle(divi , 5);
        num7 = new JButton("7");  
            num7.setBounds(x1, y4, ButtonWidth, ButtonHeight);
                buttonStyle(num7 , 1);  
                    num7.addActionListener(this);   
                        add(num7);
        num8 = new JButton("8");  
            num8.setBounds(x2, y4, ButtonWidth, ButtonHeight); 
                buttonStyle(num8 , 1);   
                    num8.addActionListener(this);
                        add(num8);
        num9 = new JButton("9");   
            num9.setBounds(x3, y4, ButtonWidth, ButtonHeight); 
                buttonStyle(num9 , 1); 
                    num9.addActionListener(this);    
                        add(num9);
        mP = new JButton("M+");   
            mP.setBounds(x4 , y4, ButtonWidth, ButtonHeight); 
                mP.addActionListener(this);
                    add(mP); 
                        buttonStyle(mP , 5);
        mM = new JButton("M-");  
            mM.setBounds(x5, y4, ButtonWidth, ButtonHeight); 
                mM.addActionListener(this); 
                    add(mM); 
                        buttonStyle(mM , 5);
        
        plueMinus= new JButton("+/-");
            plueMinus.setBounds(x0, y6, ButtonWidth, ButtonHeight);    
                plueMinus.addActionListener(this);    
                    add(plueMinus);  
                        buttonStyle(plueMinus , 5);
        MS = new JButton("MS");   
            MS.setBounds(x1, y6, ButtonWidth, ButtonHeight);  
                MS.addActionListener(this);  
                    add(MS);    
                        buttonStyle(MS , 5);
        MR = new JButton("MR");    
            MR.setBounds(x2, y6, ButtonWidth, ButtonHeight);   
                MR.addActionListener(this); 
                    add(MR);   
                        buttonStyle(MR , 5);
        MC = new JButton("MC");  
            MC.setBounds(x3, y6, ButtonWidth, ButtonHeight);  
                MC.addActionListener(this); 
                    add(MC);    
                        buttonStyle(MC , 5);
        backspace = new JButton("<<"); 
            backspace.setBounds(x4, y6, ButtonWidth, ButtonHeight); 
                backspace.addActionListener(this); 
                    add(backspace);   
                        buttonStyle(backspace , 5);
        clear = new JButton("C");  
            clear.setBounds(x5, y6, ButtonWidth, ButtonHeight); 
                clear.addActionListener(this);  
                    buttonStyle(clear , 2); 
                        add(clear);    
        
        sin = new JButton("Sin");  
            sin.setBounds(x0, y5, ButtonWidth, ButtonHeight);  
                sin.addActionListener(this);  
                    add(sin);
                        buttonStyle(sin , 5);
        cos = new JButton("Cos"); 
            cos.setBounds(x1, y5, ButtonWidth, ButtonHeight);
                cos.addActionListener(this);
                    add(cos);
                        buttonStyle(cos , 5);
        tan = new JButton("Tan");  
            tan.setBounds(x2, y5, ButtonWidth, ButtonHeight);
                tan.addActionListener(this);  
                    add(tan); 
                        buttonStyle(tan , 5);
        pi = new JButton("π");  
            pi.setBounds(x3, y5, ButtonWidth, ButtonHeight);
                pi.addActionListener(this);
                    add(pi);
                        buttonStyle(pi , 5);
        round = new JButton("Round");   
            round.setBounds(x4, y5, ButtonWidth, ButtonHeight);  
                round.addActionListener(this);  
                    add(round);   
                        buttonStyle(round , 6);

        _2Px = new JButton("<html>2<sup>x</sup></html>");  
            _2Px.setBounds(x4, y3, ButtonWidth, ButtonHeight); 
                _2Px.addActionListener(this); 
                    add(_2Px);   
                        buttonStyle(_2Px , 5);
        shift = new JButton("Shift"); 
            shift.setBounds(x5, y7, ButtonWidth , ButtonHeight);  
                shift.addActionListener(this);  
                    add(shift);   
                        shift.addMouseListener(this); 
                            buttonStyle(shift , 4); 
        inverse = new JButton("<html>x<sup>-1</sup></html>");  
            inverse.setBounds(x2, y7, ButtonWidth, ButtonHeight);  
                inverse.addActionListener(this);  
                    add(inverse);
                        buttonStyle(inverse , 5);
        sqRoot = new JButton("√x");  
            sqRoot.setBounds(x1, y7, ButtonWidth, ButtonHeight); 
                sqRoot.addActionListener(this);  
                    add(sqRoot);
                        buttonStyle(sqRoot , 5);
        
        lg = new JButton("lg");  
            lg.setBounds(x5, y5, ButtonWidth, ButtonHeight);
                lg.addActionListener(this);   
                    add(lg);
                        buttonStyle(lg , 5);
        _xP2 = new JButton("<html>x<sup>2</sup></html>");
            _xP2.setBounds(x0, y7, ButtonWidth, ButtonHeight); 
                _xP2.addActionListener(this);   
                    add(_xP2); 
                        buttonStyle(_xP2 , 5);
        _xPy = new JButton("%"); 
            _xPy.setBounds(x5, y3, ButtonWidth, ButtonHeight);
                _xPy.addActionListener(this);  
                    add(_xPy); 
                        buttonStyle(_xPy , 5);
        
        String []box1Com1 = {"Normal","Converter","Formula"};
        fistComboBox = new JComboBox(box1Com1);   
            comboBoxStyle(fistComboBox , 2);  
                fistComboBox.setBounds(x3, y7, ButtonWidth  *2 ,  ButtonHeight); 
                    fistComboBox.addActionListener(this); 
                        add(fistComboBox);
         String []box1Com3 = {"Distance","Volum","Weight","Pressure","Number Convertion"};
       converterComboBox = new JComboBox(box1Com3); comboBoxStyle(converterComboBox , 1);  converterComboBox.setBounds(500, 90, 200, 40); converterComboBox.addActionListener(this);  add(converterComboBox);
       converterComboBoxValue01 = new JComboBox();     comboBoxStyle(converterComboBoxValue01 , 1);     converterComboBoxValue01.setBounds(685, 150, 110, 40); converterComboBoxValue01.addActionListener(this); add(converterComboBoxValue01);
       converterComboBoxValue02 = new JComboBox();    comboBoxStyle(converterComboBoxValue02 , 1);     converterComboBoxValue02.setBounds(685, 210, 110, 40);  converterComboBoxValue02.addActionListener(this);   add(converterComboBoxValue02);
       TFConvetreDisplay = new JTextField("0"); TFConvetreDisplay.setBounds(420, 155, 253, 35);   txtFieldStyle(TFConvetreDisplay , 1); TFConvetreDisplay.addKeyListener(this); add(TFConvetreDisplay);
       lableInConveterDisplay = new JLabel(""); lableInConveterDisplay.setBounds(422, 215, 250, 30);   lableStyle(lableInConveterDisplay , 1); add(lableInConveterDisplay);
       
       String []box1Com4 = {"<html>a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup></html>","C = 2 π r ","C = π d"};
       formulaComboBox = new JComboBox(box1Com4); comboBoxStyle(formulaComboBox , 1);  formulaComboBox.setBounds(490, 160, 200, 40); formulaComboBox.addActionListener(this);  add(formulaComboBox);

       TFFormulaInput01 = new JTextField("0"); TFFormulaInput01.setBounds(420, 210, 100, 35);  txtFieldStyle(TFFormulaInput01 , 1); TFFormulaInput01.addKeyListener(this);  add(TFFormulaInput01);  TFFormulaInput01.addMouseListener(this);
       TFFormulaInput02 = new JTextField("0"); TFFormulaInput02.setBounds(530, 210, 100, 35);  txtFieldStyle(TFFormulaInput02 , 1); TFFormulaInput02.addKeyListener(this); add(TFFormulaInput02);   TFFormulaInput02.addMouseListener(this); 
       TFFormulaInput03 = new JTextField("0"); TFFormulaInput03.setBounds(640, 210, 100, 35);   txtFieldStyle(TFFormulaInput03  , 1); TFFormulaInput03.addKeyListener(this); add(TFFormulaInput03); TFFormulaInput03.addMouseListener(this); 
       
       lableInformulaDisplay = new JLabel("");   lableInformulaDisplay.setBounds(535, 250, 200, 35);        lableStyle(lableInformulaDisplay ,1); add(lableInformulaDisplay);
       imagelable = new JLabel("");   imagelable.setBounds(490, 10, 157, 140);  add(imagelable);
       
       info = new JTextArea("First enter the value of 2 text fields as you like"+"\n"+"then click on the remaining text field "); info.setBounds(440, 400, 254, 45); 
                add(info);  add(info); info.setEditable(false); info.setForeground(Color.RED);
      //.....................    
        converter = new JButton("Convert");
            converter.setBounds(460, 300, ButtonWidth*2, ButtonHeight-10);
                converter.addActionListener(this);
                    buttonStyle(converter,3);
                        add(converter);
        
        reset = new JButton("Reset");
            reset.setBounds(620, 300, ButtonWidth*2, ButtonHeight-10);
                reset.addActionListener(this);
                    buttonStyle(reset,3);
                        add(reset);
        
        setVisible(true);
    }
    
    //--------------------------------------------
    public static void main(String[] args) {

        try {

            // UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");  //dark
            //   UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel"); // mac
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.out.println(e);
        }
        ScinCal a = new ScinCal();
    }
    //------------------------------------
    /// Declaration
    JTextField dis,
            TFConvetreDisplay,
            TFFormulaInput01,
            TFFormulaInput02,
            TFFormulaInput03;
    JButton num0,
            num00,
            num1,
            num2,
            num3,
            num4,
            num5,
            num6,
            num7,
            num8,
            num9,
            plus,
            minus,
            multy,
            divi,
            equal,
            backspace,
            clear,
            plueMinus,
            mP,
            mM,
            MS,
            MR,
            MC,
            shift,
            sin,
            cos,
            tan,
            pi,
            _xP2,
            _2Px,
            _xPy,
            sqRoot,
            inverse,
            lg,
            round,
            exponant,
          converter,
            reset,
            dot,
            cruelty;
    JLabel lableInConveterDisplay , lableInformulaDisplay , imagelable ;
    JTextArea info;
    JComboBox fistComboBox,
            converterComboBox,
            converterComboBoxValue01,
            converterComboBoxValue02,
            formulaComboBox,
            formulaComboBoxValue01;

   //---------------------------
    
    boolean displayOperator(){
        
        if(dis.getText().equals("+")|dis.getText().equals("-")|dis.getText().equals("/")|dis.getText().equals("*")|dis.getText().equals("^")){
            return true;
        }else{
            return false;
        }    
    }
    
    void maxTextCount() {
        final int MAX_TEXT_LEN = 21;

        if (dis.getText().length() == MAX_TEXT_LEN) {
            String s = dis.getText().substring(0, dis.getText().length() - 1);
            dis.setText(s);
        } else if (dis.getText().length() > MAX_TEXT_LEN) {
            int x = (dis.getText().length() - MAX_TEXT_LEN);
            dis.setText(dis.getText().substring(0, dis.getText().length() - x));
        }
    }
    
     void maxTextCountConverter() {
        final int MAX_TEXT_LEN = 15;
         if (TFConvetreDisplay.getText().length() == MAX_TEXT_LEN) {
            String s = TFConvetreDisplay.getText().substring(0, TFConvetreDisplay.getText().length() - 1);
            TFConvetreDisplay.setText(s);
        } else if (TFConvetreDisplay.getText().length() > MAX_TEXT_LEN) {
            int x = (TFConvetreDisplay.getText().length() - MAX_TEXT_LEN);
            TFConvetreDisplay.setText(TFConvetreDisplay.getText().substring(0, TFConvetreDisplay.getText().length() - x));
        }
    }

    void clearFirstZero() {
        if (dis.getText().equals("0")) {
            dis.setText("");
        }
    }
    void clearFirstZeroConverter() {
        if (TFConvetreDisplay.getText().equals("0")) {
            TFConvetreDisplay.setText("");
        }
    }

    void zeroAndDoubleZero(String number) {
        if (dis.getText().equals("0")) {
            dis.setText("0");
        }else if(displayOperator()){ 
            operator=dis.getText();
            operationCount++;
            dis.setText("0");
        }else {
            dis.setText(dis.getText() + number);
        }
    }
    
    void calculation(){
        if(operationCount==0){
            value1=Double.valueOf(dis.getText());
        }
        else if(operationCount>0){
            value2=Double.valueOf(dis.getText());
            if(operator.equals("+")){
                value1+=value2;}
                if(operator.equals("-")){
                value1-=value2;}
                if(operator.equals("/")){
                value1/=value2;}
                if(operator.equals("*")){
                value1*=value2;}
                
                value2=0;
            
        }
        System.out.println(value1+"\t"+value2);
    }
    
    void shiftCalculationMethod(){
        try{
    //    if(shiftTrue == false){
               double xxdis = Double.parseDouble(dis.getText());
        if(sniceV.equals("Sin")){
            double vaT =   Math.sin(Math.toRadians(xxdis));
            dis.setText(String.valueOf(vaT));
        }
        else if(sniceV.equals("Cos")){
            double vaT =   Math.cos(Math.toRadians(xxdis));
            dis.setText(String.valueOf(vaT));
        }
        else if(sniceV.equals("Tan")){
            double vaT =   Math.tan(Math.toRadians(xxdis));
            dis.setText(String.valueOf(vaT));
        }    
        else if( sniceV.equals("<html>2<sup>x</sup></html>")){
            double vaT =   Math.pow(2,xxdis);
            dis.setText(String.valueOf(vaT));
        }
        else if(sniceV.equals("log")){
            double vaT =   Math.log(xxdis);
            dis.setText(String.valueOf(vaT));
        }
        else if(sniceV.equals("<html>x<sup>2</sup></html>")){
            double vaT =   Math.pow(xxdis,2);
            dis.setText(String.valueOf(vaT));
        }
//.... x  y two values        
        else if(sniceV.equals("<html>x<sup>y</sup></html>")){
            double vaT =   Math.pow(xxdis ,xxdis);
            dis.setText(String.valueOf(vaT));
        }
//....        
        else if(sniceV.equals("<html>x<sup>-1</sup></html>")){
            double vat2 = 1 / Double.parseDouble(dis.getText());
            dis.setText(String.valueOf(vat2));
        }
       
        else if(sniceV.equals("√x")){
            double vaT =   Math.sqrt(xxdis);
            dis.setText(String.valueOf(vaT));
        }
        else if(sniceV.equals("π")){
           dis.setText(String.valueOf(Math.PI));
       }
        else if(sniceV.equals("Round")){
           dis.setText(String.valueOf(Math.round(xxdis)));
       }
       else if (sniceV.equals("x!")) {
          if(xxdis>0){
            int vaT=Integer.parseInt(dis.getText());
            int vaT2=vaT;
            for(int i=1 ; i<vaT ; i++){
                vaT2 *= i;
            }
            dis.setText(String.valueOf(vaT2));
           }else{
                JOptionPane.showMessageDialog(this, "Enter the value > 0", "Syntax Error", JOptionPane.ERROR_MESSAGE);
           }
        }
       else if(sniceV.equals("%")){
           dis.setText(String.valueOf(xxdis / 100));
       }
       else if(sniceV.equals("<html>10<sup>x</sup></html>")){
            double vaT =   Math.pow(10,xxdis);
            dis.setText(String.valueOf(vaT));
        } 
    // }   
       //.........
  //  else if(shiftTrue == true){ 
      //   double xxdis = Double.parseDouble(dis.getText());
       else if(sniceV.equals("log")){
           dis.setText(String.valueOf(Math.log10(xxdis)));
       }  
       else if(sniceV.equals("<html>x<sup>3</sup></html>")){
          dis.setText(String.valueOf( xxdis * xxdis  * xxdis));
       }
        //.......
       else if(sniceV.equals("<html>s<sup>-1</sup></html>")){
            double vaT =   Math.asin(Math.toRadians(xxdis));
            dis.setText(String.valueOf(vaT));
        }
       else if(sniceV.equals("<html>c<sup>-1</sup></html>")){
            double vaT =   Math.acos(Math.toRadians(xxdis));
            dis.setText(String.valueOf(vaT));
        }
       else if(sniceV.equals("<html>t<sup>-1</sup></html>")){
            double vaT =   Math.atan(Math.toRadians(xxdis));
            dis.setText(String.valueOf(vaT));
        } 
       else if(sniceV.equals("<html><sup>3</sup>√</html>")){
            dis.setText(String.valueOf(Math.cbrt(xxdis)));
        } 
       else if(sniceV.equals("<html>x<sup>+1</sup></html>")){
                if(dis.getText().contains("-")){
                    double vaT = xxdis / -1;
                    dis.setText(String.valueOf(vaT));
                }else{
                    double vaT = xxdis / 1;
                    dis.setText(String.valueOf(vaT));
                }
        }
       else if(sniceV.equals("|x|")){
            dis.setText(String.valueOf(Math.abs(xxdis)));
        }
   //     shiftTrue = false;
   //  }
        }catch(NumberFormatException e){ JOptionPane.showMessageDialog(null, "Enter the integer value","Syntax Error",JOptionPane.ERROR_MESSAGE);}
    }
    
    void shiftTF(){
        if(shiftCountCC == 1){   
        sin.setText("<html>s<sup>-1</sup></html>"); 
        cos.setText("<html>c<sup>-1</sup></html>"); 
        tan.setText("<html>t<sup>-1</sup></html>");
        inverse.setText("<html>x<sup>+1</sup></html>");
         lg.setText("log");  
         sqRoot.setText("<html><sup>3</sup>√</html>");
        _xP2.setText("<html>x<sup>3</sup></html>");
         cruelty.setText("|x|");
         shift.setBackground(new Color(0,236,0));
       //  shiftCount =100;
     }else if(shiftCountCC == 98){
            sin.setText("Sin"); 
            cos.setText("Cos");  
            tan.setText("Tan"); 
            inverse.setText("<html>x<sup>-1</sup></html>");
            lg.setText("lg"); 
            sqRoot.setText("√x");
            _xP2.setText("<html>x<sup>2</sup></html>"); 
            cruelty.setText("x!");
            pi.setText("π");
            round.setText("Round");
            shift.setBackground(new Color(80,236,236));
        //    shiftCount =100;
     }else if(shiftCountCC == 2){
            sin.setText("a"); 
            cos.setText("b");  
            tan.setText("c"); 
            pi.setText("d");
            round.setText("e");
            lg.setText("f");
            shift.setBackground(new Color(100,236,120));
          //  shiftCount =100;
     }
    }
    
    void checkHBOD(){
                if(listconverterComboBoxValue01.equals("Hex")){
                     shiftCountCC = 2;
                        shiftTF();
                            shiftCount = 2;
                }else if(listconverterComboBoxValue01.equals("Dec")){
                    shiftCountCC = 98;
                        shiftTF();
                             shiftCount = 10;
                }else if(listconverterComboBoxValue01.equals("Oct")){
                    shiftCountCC = 98;
                        shiftTF();
                            shiftCount = 88;
                }else if(listconverterComboBoxValue01.equals("Bin")){
                    shiftCountCC = 98;
                        shiftTF();
                            shiftCount = 22;
                }else{
                    shiftCountCC = 98;
                        shiftTF();
                }
    }
 
    
    void Cmethod01(){
        if(!TFFormulaInput01.getText().equals(TFF01) & !TFFormulaInput01.getText().isEmpty()){
            valTFF0 = Double.parseDouble(TFFormulaInput01.getText());
        }
        if(!TFFormulaInput02.getText().equals(TFF02) & !TFFormulaInput02.getText().isEmpty()){
            valTFF1 = Double.parseDouble(TFFormulaInput02.getText());
        }
        if(!TFFormulaInput03.getText().equals(TFF03) & !TFFormulaInput03.getText().isEmpty()){
            valTFF2 = Double.parseDouble(TFFormulaInput03.getText());
        }
        
        if(stringTFFormulaInputSum.equals(" a^2  =  ")){  
                double c =  Math.pow(valTFF1,2)  + Math.pow(valTFF2,2)  ;
              lableInformulaDisplay.setText("a  =   " + String.valueOf( Math.sqrt(c)));    
        }else if(stringTFFormulaInputSum.equals(" b^2  +  ")){
             double c =  Math.pow(valTFF0,2)   -  Math.pow(valTFF2,2)  ;
            lableInformulaDisplay.setText("b  =   " + String.valueOf( Math.sqrt(c))); 
        }else if(stringTFFormulaInputSum.equals(" c^2 ")){  
            double c =  Math.pow(valTFF0,2)   -  Math.pow(valTFF1,2)  ;
            lableInformulaDisplay.setText("c  =   " + String.valueOf( Math.sqrt(c)));  
        }
    }
     void Cmethod02(){
         if(!TFFormulaInput01.getText().equals(TFF01) & !TFFormulaInput01.getText().isEmpty()){
            valTFF0 = Double.parseDouble(TFFormulaInput01.getText());
        }
        if(!TFFormulaInput03.getText().equals(TFF03) & !TFFormulaInput03.getText().isEmpty()){
            valTFF2 = Double.parseDouble(TFFormulaInput03.getText());
        }
        if(valueformulaComboBox.equals("C = 2 π r ")){
             if(stringTFFormulaInputSum.equals(" C  =  ")){
                     double c =  Math.PI * 2  * valTFF2  ;
                    lableInformulaDisplay.setText("C  =  " + String.valueOf(c)); 
            }
            else if(stringTFFormulaInputSum.equals(" r      ")){
                    double c = valTFF0  / Math.PI * 2  ;
                     lableInformulaDisplay.setText("r  =  " + String.valueOf(c)); 
            }
        }
        else if(valueformulaComboBox.equals("C = π d")){
             if(stringTFFormulaInputSum.equals(" C  =  ")){
                     double c =  Math.PI * valTFF2  ;
                    lableInformulaDisplay.setText("C  =  " + String.valueOf(c)); 
            }
            else if(stringTFFormulaInputSum.equals(" d      ")){
                    double c = valTFF0  / Math.PI ;
                    lableInformulaDisplay.setText("d  =  " + String.valueOf(c)); 
            }
        }
        
     }
     
     
    
    void frameTextClearandBuild(int x){
        if(x == 1){
            TFFormulaInput01.setText(" a^2  =  ");    TFF01 = " a^2  =  "; 
                  TFFormulaInput02.setText(" b^2  +  ");  TFF02 = " b^2  +  ";
                        TFFormulaInput03.setText(" c^2 ");  TFF03 = " c^2 ";
                      
        }else if(x == 2){
            TFFormulaInput01.setText(" C  =  ");    TFF01 = " C  =  "; 
                  TFFormulaInput02.setText(" 2 π   *   ");  TFFormulaInput02.setEditable(false); TFF02 = " 2 π   *   "; 
                        TFFormulaInput03.setText(" r      "); TFF03 = " r      "; 
                            
        }else if(x == 3){
            TFFormulaInput01.setText(" C  =  "); TFF01 = " C  =  ";
                  TFFormulaInput02.setText("  π   *   ");  TFFormulaInput02.setEditable(false);  TFF02 = "  π   *   "; 
                        TFFormulaInput03.setText(" d      "); TFF03 = " d      ";
                            
        }else if(x == 4){
                if(valueformulaComboBox.equals("<html>a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup></html>")){
                     TFFormulaInput01.setText(" a^2  =  "); TFF01 = " a^2  =  ";
                      
                }else if(valueformulaComboBox.equals("C = 2 π r ")|valueformulaComboBox.equals("C = π d")){
                     TFFormulaInput01.setText(" C  =  ");  TFF01 = " C  =  ";
                       
                }
        }else if(x == 5){
                if(valueformulaComboBox.equals("<html>a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup></html>")){
                     TFFormulaInput02.setText(" b^2  +  ");  TFF02 = " b^2  +  ";
                       
                }else if(valueformulaComboBox.equals("C = 2 π r ")){
                     TFFormulaInput02.setText(" 2 π   *   "); TFF02 = " 2 π   *   ";
                       
                }else if(valueformulaComboBox.equals("C = π d")){
                     TFFormulaInput02.setText("  π   *   ");   TFF02 = "  π   *   ";
                       
                }
        }else if(x == 6){
                if(valueformulaComboBox.equals("<html>a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup></html>")){
                     TFFormulaInput03.setText(" c^2 ");  TFF03 =  " c^2 ";
                        
                }else if(valueformulaComboBox.equals("C = 2 π r ")){
                     TFFormulaInput03.setText(" r      "); TFF03 = " r      ";
                       
                }else if(valueformulaComboBox.equals("C = π d")){
                     TFFormulaInput03.setText(" d      ");  TFF03 = " d      ";
                       
                }
        }
       
    }
    
    void imageMethod(String selectedImagePath){
       // File file = new File(getClass().getResource(selectedImagePath).getFile());
        ImageIcon ii = new ImageIcon(getClass().getResource(selectedImagePath));
        Image image = ii.getImage().getScaledInstance(imagelable.getWidth(), imagelable.getHeight(),Image.SCALE_SMOOTH);
        imagelable.setIcon(new ImageIcon(image));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == formulaComboBox){ 
            valueformulaComboBox = (String) formulaComboBox.getSelectedItem();
            if(valueformulaComboBox.equals("<html>a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup></html>")){
                    shiftCount = 200;    resetMethod2();
                    imageMethod("/img/calPi.jpg");
                        frameTextClearandBuild(1); 
            }else if(valueformulaComboBox.equals("C = 2 π r ")){
                    shiftCount = 220;   resetMethod2();
                    imageMethod("/img/calcr.jpg");
                        frameTextClearandBuild(2); 
            }else if(valueformulaComboBox.equals("C = π d")){ 
                   shiftCount = 240;   resetMethod2();
                    imageMethod("/img/calcd.jpg");
                        frameTextClearandBuild(3); 
            }
        }
    else if(e.getActionCommand().equals("Shift")){
            if(shiftCountCC == 98){
                shiftTrue = true;  
                shiftCountCC = 1;
                shiftTF();
            }else if(shiftCountCC == 1){
                shiftTrue = false;  
                shiftCountCC = 98;
                shiftTF();
            }
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("<html>x<sup>2</sup></html>")){
                    sniceV = "<html>x<sup>2</sup></html>" ;
                    shiftCalculationMethod();
            }else if(e.getActionCommand().equals("<html>x<sup>3</sup></html>")){
                    sniceV = "<html>x<sup>3</sup></html>" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("<html>2<sup>x</sup></html>")){
                    sniceV = "<html>2<sup>x</sup></html>" ;
                    shiftCalculationMethod();
            }else if(e.getActionCommand().equals("<html>10<sup>x</sup></html>")){
                    sniceV = "<html>10<sup>x</sup></html>" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("√x")){
                    sniceV = "√x" ;
                    shiftCalculationMethod();
            }else if(e.getActionCommand().equals("<html><sup>3</sup>√</html>")){
                    sniceV = "<html><sup>3</sup>√</html>" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("<html>x<sup>-1</sup></html>")){
                    sniceV = "<html>x<sup>-1</sup></html>" ;
                    shiftCalculationMethod();
            }
            else if(e.getActionCommand().equals("<html>x<sup>+1</sup></html>")){
                    sniceV = "<html>x<sup>+1</sup></html>" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("π")){
                    sniceV = "π" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("Tan")){
                    sniceV = "Tan" ;
                    shiftCalculationMethod();
            }else if(e.getActionCommand().equals("<html>t<sup>-1</sup></html>")){
                    sniceV = "<html>t<sup>-1</sup></html>" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("Cos")){
                    sniceV = "Cos" ;
                    shiftCalculationMethod();
            }else if(e.getActionCommand().equals("<html>c<sup>-1</sup></html>")){
                    sniceV = "<html>c<sup>-1</sup></html>" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("Sin")){
                    sniceV = "Sin" ;
                    shiftCalculationMethod();
            }else if(e.getActionCommand().equals("<html>s<sup>-1</sup></html>")){
                    sniceV = "<html>s<sup>-1</sup></html>" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("lg")){
                    sniceV = "lg" ;
                    shiftCalculationMethod();
            }else if(e.getActionCommand().equals("log")){
                    sniceV = "log" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("x!")){
                    sniceV = "x!" ;
                    shiftCalculationMethod();
            }else if(e.getActionCommand().equals("|x|")){
                    sniceV = "|x|" ;
                    shiftCalculationMethod();
            }
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("%")){
                    sniceV = "%" ;
                    shiftCalculationMethod();
            }  
            //----------***********----------//----------***********----------
            else if(e.getActionCommand().equals("Round")){
                    sniceV = "Round" ;
                    shiftCalculationMethod();
            } 
            //----------***********----------//----------***********----------
               //----------***********----------//----------***********----------
                else if (e.getActionCommand().equals("1")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("1");
                        }
                        else{
                            dis.setText(dis.getText()+"1");
                        }
                        maxTextCount();
                      }else if( shiftCount  == 22 | shiftCount == 2 | shiftCount == 10 | shiftCount == 88  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"1");
                          maxTextCountConverter();
                      }
                    }
                else if (e.getActionCommand().equals("2")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("2");
                        }
                        else{
                            dis.setText(dis.getText()+"2");
                        }
                        maxTextCount();
                      }else if( shiftCount == 2 | shiftCount == 10 | shiftCount == 88  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"2");
                          maxTextCountConverter();
                      }
                    }
                 else if (e.getActionCommand().equals("3")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("3");
                        }
                        else{
                            dis.setText(dis.getText()+"3");
                        }
                        maxTextCount();
                      }else if( shiftCount == 2 | shiftCount == 10 | shiftCount == 88  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"3");
                          maxTextCountConverter();
                      }
                    }
                  else if (e.getActionCommand().equals("4")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("4");
                        }
                        else{
                            dis.setText(dis.getText()+"4");
                        }
                        maxTextCount();
                      }else if( shiftCount == 2 | shiftCount == 10 | shiftCount == 88  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"4");
                          maxTextCountConverter();
                      }
                    }
                   else if (e.getActionCommand().equals("5")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("5");
                        }
                        else{
                            dis.setText(dis.getText()+"5");
                        }
                        maxTextCount();
                      }else if( shiftCount == 2 | shiftCount == 10 | shiftCount == 88  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"5");
                          maxTextCountConverter();
                      }
                    }
                    else if (e.getActionCommand().equals("6")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("6");
                        }
                        else{
                            dis.setText(dis.getText()+"6");
                        }
                        maxTextCount();
                      }else if( shiftCount == 2 | shiftCount == 10 | shiftCount == 88  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"6");
                          maxTextCountConverter();
                      }
                    }
                   else if (e.getActionCommand().equals("7")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("7");
                        }
                        else{
                            dis.setText(dis.getText()+"27");
                        }
                        maxTextCount();
                      }else if( shiftCount == 2 | shiftCount == 10 | shiftCount == 88  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"7");
                          maxTextCountConverter();
                      }
                    } 
                    else if (e.getActionCommand().equals("8")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("8");
                        }
                        else{
                            dis.setText(dis.getText()+"8");
                        }
                        maxTextCount();
                      }else if( shiftCount == 2 | shiftCount == 10  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"8");
                          maxTextCountConverter();
                      }
                    }
                    else if (e.getActionCommand().equals("9")) {
                        clearFirstZero();
                      if(shiftCount == 100){ 
                        if(displayOperator()){
                            operator=dis.getText();
                            System.out.println(operationCount);
                            operationCount++;
                            dis.setText("9");
                        }
                        else{
                            dis.setText(dis.getText()+"9");
                        }
                        maxTextCount();
                      }else if( shiftCount == 2 | shiftCount == 10  | shiftCount > 101){
                          clearFirstZeroConverter();
                          TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"9");
                          maxTextCountConverter();
                      }
                    } 
                    else if (e.getActionCommand().equals("0")) {
                        if(shiftCount == 100){ 
                            zeroAndDoubleZero("0");
                                maxTextCount();
                                    //operationCount=true;
                         }else if( shiftCount == 22 | shiftCount == 10| shiftCount == 2| shiftCount == 88 | shiftCount > 101){
                            clearFirstZeroConverter();
                                TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"0");
                                    maxTextCountConverter();
                        }
                         
                        
            
                    }
                    else if (e.getActionCommand().equals("00")) {
                       if(shiftCount == 100){
                         zeroAndDoubleZero("00");
                         maxTextCount();
           
                       }else if( shiftCount == 22 | shiftCount == 10| shiftCount == 2| shiftCount == 88 | shiftCount > 101){
                            clearFirstZeroConverter();
                                TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"00");
                                    maxTextCountConverter();
                        }

                    }  
               //----------***********----------//----------***********---------- 
            //----------***********----------//----------***********----------
                    else if (e.getActionCommand().equals(".")) {
                        if(shiftCount == 100){    
                            if (!dis.getText().contains(".") ) {
                                    dis.setText(dis.getText() + ".");
                            }
                        }else if( shiftCount > 101){ 
                            if (!TFConvetreDisplay.getText().contains(".") ) {
                                  TFConvetreDisplay.setText(TFConvetreDisplay.getText() + ".");
                            }
                        }  
                    }
                     //----------***********----------//----------***********---------- 
            //----------***********----------//----------***********----------
                    else if(e.getActionCommand().equals("a")){
                            clearFirstZeroConverter();
                            if(TFConvetreDisplay.getText().equals("0")){
                                TFConvetreDisplay.setText("a");
                            }else{
                                TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"a");
                            }
                    }
                    else if(e.getActionCommand().equals("b")){
                            clearFirstZeroConverter();
                            if(TFConvetreDisplay.getText().equals("0")){
                                TFConvetreDisplay.setText("b");
                            }else{
                                TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"b");
                            }
                    }
                    else if(e.getActionCommand().equals("c")){
                            clearFirstZeroConverter();
                            if(TFConvetreDisplay.getText().equals("0")){
                                TFConvetreDisplay.setText("c");
                            }else{
                                TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"c");
                            }
                    }
                    else if(e.getActionCommand().equals("d")){
                            clearFirstZeroConverter();
                            if(TFConvetreDisplay.getText().equals("0")){
                                TFConvetreDisplay.setText("d");
                            }else{
                                TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"Dd");
                            }
                    }
                    else if(e.getActionCommand().equals("e")){
                            clearFirstZeroConverter();
                            if(TFConvetreDisplay.getText().equals("0")){
                                TFConvetreDisplay.setText("e");
                            }else{
                                TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"e");
                            }
                    }
                    else if(e.getActionCommand().equals("f")){
                            clearFirstZeroConverter();
                            if(TFConvetreDisplay.getText().equals("0")){
                                TFConvetreDisplay.setText("f");
                            }else{
                                TFConvetreDisplay.setText(TFConvetreDisplay.getText()+"f");
                            }
                    }
                     //----------***********----------//----------***********---------- 
            //----------***********----------//----------***********----------
        else if(e.getActionCommand().equals("+/-")){
            if(dis.getText().contains("-")& dis.getText().length()!=1){
                String s=dis.getText().substring(1, dis.getText().length());
                dis.setText(s);
            }
            else if(dis.getText().contains("-")& dis.getText().length()==1){
                dis.setText("0");
            }
            else{
                if(dis.getText().indexOf("0")==0& !dis.getText().contains("."))
                    dis.setText(dis.getText());
                else
                    dis.setText("-"+dis.getText());
             } 
        }
                    
        else if(e.getActionCommand().equals("+")) {
            if(displayOperator()){
            dis.setText("+");
            }
            else{
            calculation();
            dis.setText("+");
            }
        }
        else if (e.getActionCommand().equals("-")) {
            
            if(displayOperator()){
            dis.setText("-");
            }
            else{
            calculation();
            dis.setText("-");
            }
        }
        else if (e.getActionCommand().equals("*")) {
            
            if(displayOperator()){
            dis.setText("*");
            }else if(operationCount == 0 & dis.getText().equals("0")){
                dis.setText("0");
                JOptionPane.showMessageDialog(this, "Syntax Error", "Syntax Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
            calculation();
            dis.setText("*");
            }
        }
        else if (e.getActionCommand().equals("/")) {
            
            if(displayOperator()){
            dis.setText("/");
            }else if(operationCount == 0 & dis.getText().equals("0")){
                dis.setText("0");
                JOptionPane.showMessageDialog(this, "Syntax Error", "Syntax Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
            calculation();
            dis.setText("/");
            }
        }

        else if (e.getActionCommand().equals("=")) {
             value2 = Double.parseDouble(dis.getText());
                if (operator.equals("+")) {
                    sum = value1 + value2;
                    dis.setText(String.valueOf(sum));
                }
                else if (operator.equals("-")) {
                sum = value1 - value2;
                dis.setText(String.valueOf(sum));
                }
                else if (operator.equals("*")) {
                sum = value1 * value2;
                dis.setText(String.valueOf(sum));
                }
                else if (operator.equals("/")) {
                sum = value1 / value2;
                dis.setText(String.valueOf(sum));
                }
            value1=0;
            value2=0;
            operationCount=0;
        }
        
        else if (e.getActionCommand().equals("<<")) {
                dis.setText(dis.getText().substring(0,dis.getText().length()-1));
            if(dis.getText().equals("")){
                dis.setText("0");
                dis.grabFocus();
                
            }
        }
        else if (e.getActionCommand().equals("C")) {
            dis.setText("0");
            value1=0;
            value2=0;
            sum=0;
            shiftCount = 100;
            operationCount=0;
            resetMethod();
            dis.grabFocus();
        }
        else if (e.getActionCommand().equals("MS")) {
           try{
           memorySave=Double.valueOf(dis.getText());
           MC.setEnabled(true);
           MR.setEnabled(true); 
           }catch(NumberFormatException e2){
              JOptionPane.showMessageDialog(null, "Invalid input","Syntax Error",JOptionPane.ERROR_MESSAGE);
           }
        }
        else if (e.getActionCommand().equals("MR")) {
            dis.setText(String.valueOf(memorySave));
        }
        else if (e.getActionCommand().equals("MC")) {
            memorySave=0;
           dis.setText("0");
           MC.setEnabled(false);
           MR.setEnabled(false);
        }
        
        else if(e.getActionCommand().equals("M+")){
            try {
                memorySave+=Double.parseDouble(dis.getText());
                MR.setEnabled(true);
                MC.setEnabled(true);
            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(null, "Invalid input", "Syntax Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if(e.getActionCommand().equals("M-")){
            try {
                memorySave-=Double.parseDouble(dis.getText());
                MR.setEnabled(true);
                MC.setEnabled(true);
            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(null, "Invalid input" , "Syntax Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if(e.getSource() == fistComboBox){
            String s = (String)fistComboBox.getSelectedItem();
            if(s.equals("Normal")){
                resetMethod();
                this.setResizable(true);    this.setSize(400,500); this.setResizable(false); shiftCount = 100;
            }else if(s.equals("Converter")){
                resetMethod();
               visiblePanelFalse("Formula");visiblePanelTrue("Converter");
                this.setResizable(true);   this.setSize(810,500); this.setResizable(false);
            }else if(s.equals("Formula")){
                resetMethod();
               visiblePanelFalse("Converter"); visiblePanelTrue("Formula");
                this.setResizable(true);   this.setSize(810,500);  this.setResizable(false);
            }
           }
            
            else if(e.getSource() == converterComboBox){
                    lableInConveterDisplay.setEnabled(false);
            StringconverterComboBox = (String)converterComboBox.getSelectedItem();
            if(StringconverterComboBox.equals("Distance")){
                converterComboBoxValue01.removeAllItems(); 
                    converterComboBoxValue02.removeAllItems(); shiftCount = 120;
                    resetMethod();
                String []box3Com3 = {"km" , "m" , "cm" , "mm" , "dm", "nm" , "um" , "inch" , "foot" };
                for(String ss : box3Com3){
                    converterComboBoxValue01.addItem(ss);
                        converterComboBoxValue02.addItem(ss);
                }
            }else if(StringconverterComboBox.equals("Volum")){
                 converterComboBoxValue01.removeAllItems(); 
                    converterComboBoxValue02.removeAllItems(); shiftCount = 140;
                    resetMethod();
                 String []box3Com32 = {"L" , "ml"};
                 for(String ss : box3Com32){
                     converterComboBoxValue01.addItem(ss);
                        converterComboBoxValue02.addItem(ss);
                 }
            }else if(StringconverterComboBox.equals("Weight")){
                 converterComboBoxValue01.removeAllItems(); 
                    converterComboBoxValue02.removeAllItems(); shiftCount = 160;
                    resetMethod();
                 String []box3Com33 = {"T" , "kg" , "g" , "mg"};
                 for(String ss : box3Com33){
                     converterComboBoxValue01.addItem(ss);
                        converterComboBoxValue02.addItem(ss);
                 }
            }else if(StringconverterComboBox.equals("Pressure")){
                 converterComboBoxValue01.removeAllItems();
                    converterComboBoxValue02.removeAllItems(); shiftCount = 180;
                    resetMethod();
                 String []box3Com33 = {"Pa" , "Bar" , "Torr"};
                 for(String ss : box3Com33){
                     converterComboBoxValue01.addItem(ss);
                        converterComboBoxValue02.addItem(ss);
                 }
            }else if(StringconverterComboBox.equals("Number Convertion")){
                  converterComboBoxValue01.removeAllItems();
                    converterComboBoxValue02.removeAllItems();
                    resetMethod();
                 String []box3Com33 = {"Dec" , "Bin" , "Oct" , "Hex"};
                 for(String ss : box3Com33){
                     converterComboBoxValue01.addItem(ss);
                        converterComboBoxValue02.addItem(ss);
                 }
            }else{
                converterComboBoxValue01.removeAllItems();
                    converterComboBoxValue02.removeAllItems();
            }
        }
        else if(e.getSource() == converterComboBoxValue01){
                listconverterComboBoxValue01 = (String)converterComboBoxValue01.getSelectedItem();
                try{
                if(StringconverterComboBox.equals("Number Convertion")){ 
                     if(listconverterComboBoxValue01.equals("Hex")|listconverterComboBoxValue01.equals("Oct")|listconverterComboBoxValue01.equals("Dec")|listconverterComboBoxValue01.equals("Bin")){
                         checkHBOD();  
                         resetMethod();
                     }
                }
                }catch(NullPointerException e2){
                
                }
                TFConvetreDisplay.grabFocus();
        }
        else if(e.getSource() == converterComboBoxValue02){
            listconverterComboBoxValue02 = (String)converterComboBoxValue02.getSelectedItem();
            if(TFConvetreDisplay.getText().equals("")){
                TFConvetreDisplay.grabFocus();
            }else{
                converter.grabFocus();
            }
        } 
        else if(e.getActionCommand().equals("Convert")){
                if(StringconverterComboBox.equals("Distance") ){
                     DistanceConvertion(); 
                }else if( StringconverterComboBox.equals("Volum") ){ 
                    VolumConvertion();
                }else if( StringconverterComboBox.equals("Weight")){
                    WeightConvertion();
                }else if(StringconverterComboBox.equals("Pressure")){
                    PressureConverter();
                }else if(StringconverterComboBox.equals("Number Convertion")){ 
                    NumberConverter(); 
                }else if(valueformulaComboBox.equals("<html>a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup></html>")){
                    Cmethod01();
                }else if(valueformulaComboBox.equals("C = 2 π r ")){
                    Cmethod02();
                }else if(valueformulaComboBox.equals("C = π d")){
                    Cmethod02();
                }
        }  //  
        else if(e.getActionCommand().equals("Reset")){
            resetMethod();
            TFConvetreDisplay.grabFocus();
        }  
         
            
    }
    void resetMethod2(){
            TFFormulaInput01.setText("");
            TFFormulaInput02.setText("");
            TFFormulaInput03.setText("");
            lableInformulaDisplay.setText("0");
            imagelable.setText("No select formula");
            TFF01="" ; TFF02=""; TFF03="";
            valTFF0 = 0 ; valTFF1 = 0; valTFF2 = 0;
    }
    void resetMethod(){
           TFConvetreDisplay.setText("");
           lableInConveterDisplay.setText("");
           
            TFFormulaInput01.setText("");
            TFFormulaInput02.setText("");
            TFFormulaInput03.setText("");
            lableInformulaDisplay.setText("0");
            imagelable.setText("No select formula");
            TFF01="" ; TFF02=""; TFF03="";
            valTFF0 = 0 ; valTFF1 = 0; valTFF2 = 0;
    }
    
    void NumberConverter(){
        try{
       String stringTFConvetreDisplay = TFConvetreDisplay.getText();
            if(listconverterComboBoxValue01.equals(listconverterComboBoxValue02)){
                lableInConveterDisplay.setText(stringTFConvetreDisplay);
            }
             else if(listconverterComboBoxValue01.equals("Dec") ){
                 int convertBase = Integer.parseInt(stringTFConvetreDisplay ,10);
                switch(listconverterComboBoxValue02){
                case "Bin":
                   lableInConveterDisplay.setText(Integer.toString(convertBase , 2));
                break;
                    case "Oct":
                   lableInConveterDisplay.setText(Integer.toString( convertBase ,8));
                break;
                         case "Hex":
                   lableInConveterDisplay.setText(Integer.toString( convertBase ,16));
                break;
                }
            }else if(listconverterComboBoxValue01.equals("Bin") ){
                 int convertBase = Integer.parseInt(stringTFConvetreDisplay , 2);
                switch(listconverterComboBoxValue02){
                case "Dec":
                   lableInConveterDisplay.setText(Integer.toString(convertBase));
                break;
                    case "Oct":
                   lableInConveterDisplay.setText(Integer.toString( convertBase ,8));
                 break;        
                         case "Hex":
                   lableInConveterDisplay.setText(Integer.toString( convertBase ,16));
                break;
                }
            }else if(listconverterComboBoxValue01.equals("Oct") ){
                 int convertBase = Integer.parseInt(stringTFConvetreDisplay , 8);
                switch(listconverterComboBoxValue02){
                case "Dec":
                   lableInConveterDisplay.setText(Integer.toString(convertBase));
                break;
                    case "Bin":
                   lableInConveterDisplay.setText(Integer.toString( convertBase ,2));
                 break;        
                         case "Hex":
                   lableInConveterDisplay.setText(Integer.toString( convertBase ,16));
                break;
                }
            } 
            else if(listconverterComboBoxValue01.equals("Hex") ){
                 int convertBase = Integer.parseInt(stringTFConvetreDisplay , 16);
                switch(listconverterComboBoxValue02){
                case "Dec":
                   lableInConveterDisplay.setText(Integer.toString(convertBase));
                break;
                    case "Bin":
                   lableInConveterDisplay.setText(Integer.toString( convertBase ,2));
                 break;        
                         case "oct":
                   lableInConveterDisplay.setText(Integer.toString( convertBase ,8));
                break;
                }
            } 
        }catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null, "Conveter Error", "Syntax Error", JOptionPane.ERROR_MESSAGE);
             TFConvetreDisplay.setText("");
             TFConvetreDisplay.grabFocus();
        }    
    }
    
    void PressureConverter(){
         String stringTFConvetreDisplay = TFConvetreDisplay.getText();
         try {
            
            if(listconverterComboBoxValue01.equals(listconverterComboBoxValue02)){
                lableInConveterDisplay.setText(stringTFConvetreDisplay);
            }
             else if(listconverterComboBoxValue01.equals("Pa") ){
                switch(listconverterComboBoxValue02){
                case "Bar":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,5)));
                break;
                    case "Torr":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 133));
                break;
                }
            }else if(listconverterComboBoxValue01.equals("Bar") ){
                switch(listconverterComboBoxValue02){
                case "Pa":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,5)));
                break;
                    case "Torr":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 750 ));
                break;
                }
            }else if(listconverterComboBoxValue01.equals("Torr") ){
                switch(listconverterComboBoxValue02){
                case "Pa":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 133 ));
                break;
                    case "Torr":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 750 ));
                break;
                }
            }
        } catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null, "Conveter Error", "Syntax Error", JOptionPane.ERROR_MESSAGE);
             TFConvetreDisplay.setText("");
             TFConvetreDisplay.grabFocus();
        } 
   
    }
    
    void WeightConvertion(){
        String stringTFConvetreDisplay = TFConvetreDisplay.getText();
        try{    
            if(listconverterComboBoxValue01.equals(listconverterComboBoxValue02)){
                lableInConveterDisplay.setText(stringTFConvetreDisplay);
            }
             else if(listconverterComboBoxValue01.equals("mg") ){
                switch(listconverterComboBoxValue02){
                case "g":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,3)));
                break;
                    case "kg":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,6)));
                break;
                        case "T":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,9)));
                break;
            }
            }else if(listconverterComboBoxValue01.equals("g") ){
                switch(listconverterComboBoxValue02){
               case "mg":
                    lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,3)));
                break;
                   case "kg":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,3)));
                break;
                       case "T":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,6)));
                break;
               }
            } else if(listconverterComboBoxValue01.equals("kg") ){
                switch(listconverterComboBoxValue02){
                case "mg":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,6)));
                break;
                    case "g":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,3)));
                break;
                        case "T":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,3)));
                break;
            }
            }else if(listconverterComboBoxValue01.equals("T") ){
                switch(listconverterComboBoxValue02){
               case "mg":
                    lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,9)));
                break;
                   case "g":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,6)));
                break;
                       case "kg":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,3)));
                break;
               }
            }
        }catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null, "Conveter Error", "Syntax Error", JOptionPane.ERROR_MESSAGE);
             TFConvetreDisplay.setText("");
             TFConvetreDisplay.grabFocus();
        }     
    }
     
    void VolumConvertion(){
        String stringTFConvetreDisplay = TFConvetreDisplay.getText();
        try{    
            if(listconverterComboBoxValue01.equals(listconverterComboBoxValue02)){
                lableInConveterDisplay.setText(stringTFConvetreDisplay);
            }
             else if(listconverterComboBoxValue01.equals("L") ){
                switch(listconverterComboBoxValue02){
                case "ml":
                   lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,3)));
                break;
            }
            }else if(listconverterComboBoxValue01.equals("ml") ){
                switch(listconverterComboBoxValue02){
               case "L":
                    lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,3)));
                break;
               }
        }
        }catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null, "Conveter Error", "Syntax Error", JOptionPane.ERROR_MESSAGE);
             TFConvetreDisplay.setText("");
             TFConvetreDisplay.grabFocus();
        }     
    }
      
    void DistanceConvertion(){
         String stringTFConvetreDisplay = TFConvetreDisplay.getText();
         try{   
            if(listconverterComboBoxValue01.equals(listconverterComboBoxValue02)){
                lableInConveterDisplay.setText(stringTFConvetreDisplay);
            }
            else if(listconverterComboBoxValue01.equals("nm")){
                switch(listconverterComboBoxValue02){
                    case "km" :
                            lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,12)));
                        break;
                    case "m" :
                            lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,9)));
                        break;
                    case "cm" :
                            lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,7)));
                        break;  
                    case "mm" :
                            lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,6)));
                        break;    
                    case "um":
                             lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,3)));
                        break;
                    case "inch" :
                            lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) /( 2.54*Math.pow(10,7))));
                        break; 
                    case "foot" :
                            lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / (3.048*Math.pow(10,8))));
                        break;     
                }
            }
            else if(listconverterComboBoxValue01.equals("um")){
               switch(listconverterComboBoxValue02){
                   case "km":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,9)));
                    break;
                case "m" :
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,6)));
                    break;
                case "cm" :
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,4)));
                    break;
                case "mm" :
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,3)));
                    break;
                case "nm":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,3)));
                    break;
                case "inch": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / (2.54 * Math.pow(10,4))));
                    break;
                case "foot":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / (3.048 * Math.pow(10,5))));
                    break; 
               }
             }
            else if(listconverterComboBoxValue01.equals("mm")){
                switch(listconverterComboBoxValue02){
                case  "km":
                          lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,6)));
                    break;
                case  "m":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,3)));
                    break;
                case  "cm":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 10));
                    break;
                case  "um": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,3)));
                    break;
                case  "nm": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,6)));
                    break;
                case    "inch": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 25.4));
                    break;
                case  "foot":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / (3.05 * Math.pow(10,2))));
                    break;
                }
            }
            else if(listconverterComboBoxValue01.equals("cm")){
               switch(listconverterComboBoxValue02){
                case  "km":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,5)));
                    break;
                case  "m": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,2)));
                    break;
                case  "mm":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 10));
                    break;
                case  "um": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,4)));
                    break;
                case  "nm":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,7)));
                    break;
                case  "inch":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 2.54));
                    break;
                case  "foot": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 30.48));
                    break;
               }
            }
            else if(listconverterComboBoxValue01.equals("m")){
                switch(listconverterComboBoxValue02){
                case  "km":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / Math.pow(10,3)));
                    break;
                case  "cm": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,2)));
                    break;
                case  "mm": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10, 3)));
                    break;
                case  "um":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,6)));
                    break;
                case  "nm":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,9)));
                    break;
                case  "inch": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 39.37));
                    break;
                case  "foot": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 3.28084));
                    break;
                }
            }
            else if(listconverterComboBoxValue01.equals("km")){
               switch(listconverterComboBoxValue02){
                case  "m": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,3)));
                    break;
                case  "cm":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,5)));
                    break;
                case  "mm": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,6)));
                    break;
                case  "um": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,9)));
                    break;
                case  "nm": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * Math.pow(10,12)));
                    break;
                case  "inch":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 39370.1));
                    break;
                case  "foot":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 3280.84));
                    break;
               }
            }
            else if(listconverterComboBoxValue01.equals("inch")){
               switch(listconverterComboBoxValue02){
                case  "km":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 39370));
                    break;
                case  "m":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 39.37));
                    break;
                case  "cm":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 2.54));
                    break;
                case  "mm": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 25.4));
                    break;
                case  "um": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 2.54 * Math.pow(10,4)));
                    break;
                case  "nm": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 2.54 * Math.pow(10,7)));
                    break;
                case  "foot": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 12));
                    break;}
            }
            else if(listconverterComboBoxValue01.equals("foot")){
               switch(listconverterComboBoxValue02){
                case  "km":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 3281));
                    break;
                case  "m":
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) / 3.281));
                    break;
                case  "cm": 
                          lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 30.48));
                    break;
                case  "mm": 
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 305));
                    break;
                case  "um": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * (3.048 * Math.pow(10,5))));
                    break;
                case  "nm": 
                        lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * (3.048 * Math.pow(10,8))));
                    break;
                case  "inch":
                         lableInConveterDisplay.setText(String.valueOf(Double.parseDouble(stringTFConvetreDisplay) * 12));
                    break;
                }
            }
         }catch(NumberFormatException e){
             JOptionPane.showMessageDialog(null, "Conveter Error", "Syntax Error", JOptionPane.ERROR_MESSAGE);
             TFConvetreDisplay.setText("");
             TFConvetreDisplay.grabFocus();
        }     
    }
    
    void visiblePanelFalse(String x){
        if(x.equals("Formula")){    //Formula
            formulaComboBox.setVisible(false);
            imagelable.setVisible(false);
            TFFormulaInput01.setVisible(false);
            TFFormulaInput02.setVisible(false);
            TFFormulaInput03.setVisible(false);
            reset.setVisible(false);
            converter.setVisible(false);
            lableInformulaDisplay.setVisible(false);
            info.setVisible(false);
        } if(x.equals("Converter")){    //Unit Converter
            TFConvetreDisplay.setVisible(false);
            lableInConveterDisplay.setVisible(false);
            converterComboBox.setVisible(false);
            converterComboBoxValue01.setVisible(false);
            converterComboBoxValue02.setVisible(false);
            reset.setVisible(false);
            converter.setVisible(false);
        }
    }
    
    void visiblePanelTrue(String x){
         if(x.equals("Formula")){    //Formula
            formulaComboBox.setVisible(true);
            imagelable.setVisible(true);
            TFFormulaInput01.setVisible(true);
            TFFormulaInput02.setVisible(true);
            TFFormulaInput03.setVisible(true);
            reset.setVisible(true);
            converter.setVisible(false);
            lableInformulaDisplay.setVisible(true);
            info.setVisible(true);
        
        } if(x.equals("Converter")){    //Unit Converter
            TFConvetreDisplay.setVisible(true);
            lableInConveterDisplay.setVisible(true);
            converterComboBox.setVisible(true);
            converterComboBoxValue01.setVisible(true);
            converterComboBoxValue02.setVisible(true);
            reset.setVisible(true);
            converter.setVisible(true);
        }
    }
    
    void hadissiyataGahuwe(){
                 if(valueformulaComboBox.equals("<html>a<sup>2</sup> = b<sup>2</sup> + c<sup>2</sup></html>")){
                    Cmethod01();
                }else if(valueformulaComboBox.equals("C = 2 π r ")){
                    Cmethod02();
                }else if(valueformulaComboBox.equals("C = π d")){
                    Cmethod02();
                }
        reset.grabFocus();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        char iNumber = e.getKeyChar();
        if(!(Character.isDigit(iNumber)) || (iNumber == KeyEvent.VK_DELETE)){ 
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(shiftCount == 100){    
        if(e.getKeyCode()>=96 & e.getKeyCode()<=105 | e.getKeyCode()>=48 & e.getKeyCode()<=57){
                clearFirstZero(); clearFirstZeroConverter();  
                maxTextCountConverter();
                if(dis.getText().length()<=20){
                    dis.setEditable(true);
                }else{
                    dis.setEditable(false);}
            }else if(e.getKeyCode()==8){
                dis.setEditable(true);
            }
            else if(e.getKeyCode()==110){
                if(!dis.getText().contains(".")){
                       dis.setText(dis.getText() + ".");
                }
            }else{
                dis.setEditable(false);
            }
         }
         else if(shiftCount > 101){     
        if(e.getKeyCode()>=96 & e.getKeyCode()<=105 | e.getKeyCode()>=48 & e.getKeyCode()<=57){
                clearFirstZero(); clearFirstZeroConverter();
                maxTextCountConverter();
                if(TFConvetreDisplay.getText().length()<=18){
                    TFConvetreDisplay.setEditable(true);
                }else{
                    TFConvetreDisplay.setEditable(false);}
            }else if(e.getKeyCode()==8){
                TFConvetreDisplay.setEditable(true);
            }
            else if(e.getKeyCode()==110){
                if(!TFConvetreDisplay.getText().contains(".")){
                     TFConvetreDisplay.setText(TFConvetreDisplay.getText() + ".");
                }
            }else{
                TFConvetreDisplay.setEditable(false);
            }
         }
      
//         if(e.getSource()==TFFormulaInput01){
//             converter.grabFocus();
//         }else if(e.getSource()==TFFormulaInput02){
//             converter.grabFocus();
//         }else if(e.getSource()==TFFormulaInput03){
//             converter.grabFocus();
//         }

              
    }

    @Override
    public void keyReleased(KeyEvent e) {          
    }

    @Override
    public void mouseClicked(MouseEvent e) {
     boolean v1 =false, v2 = false ; 
        
        if(e.getSource() == TFFormulaInput01){
           if(!TFFormulaInput02.getText().equals(TFF02) | TFFormulaInput02.getText().equals(" 2 π   *   ") | TFFormulaInput02.getText().equals("  π   *   " ) ){
               if(TFFormulaInput02.getText().isEmpty()){
                   TFFormulaInput02.setText(TFF02);
               }else{
                  v1 = true;  
               }
           }
           if(!TFFormulaInput03.getText().equals(TFF03)){
               if(TFFormulaInput03.getText().isEmpty()){
                   TFFormulaInput03.setText(TFF03);
               }else{
                  v2 = true ;
               }
           }
           if(v1 == true & v2 == true ){
               TFFormulaInput01.setEditable(false);
               stringTFFormulaInputSum = TFFormulaInput01.getText();
                hadissiyataGahuwe();
             
           }else{
               TFFormulaInput01.setEditable(true);
               TFFormulaInput01.setText("");
           }
       }
     else  if(e.getSource() == TFFormulaInput02){
           if(!TFFormulaInput01.getText().equals(TFF01)){
               if(TFFormulaInput01.getText().isEmpty()){
                   TFFormulaInput01.setText(TFF01);
               }else{
                 v1 = true;
               }
           }
           if(!TFFormulaInput03.getText().equals(TFF03)){
               if(TFFormulaInput03.getText().isEmpty()){
                   TFFormulaInput03.setText(TFF03);
               }else{
                 v2 = true;
               }
           }
           if(v1 == true & v2 == true){
               TFFormulaInput02.setEditable(false);
               stringTFFormulaInputSum = TFFormulaInput02.getText();
                hadissiyataGahuwe();
              
           }else{
               TFFormulaInput02.setText("");
               TFFormulaInput02.setEditable(true);
                
           }
       }
      else if(e.getSource() == TFFormulaInput03){
           if(!TFFormulaInput02.getText().equals(TFF02) | TFFormulaInput02.getText().equals(" 2 π   *   ") | TFFormulaInput02.getText().equals("  π   *   " )){
               if(TFFormulaInput02.getText().isEmpty()){
                   TFFormulaInput02.setText(TFF02);
               }else{
                 v1 = true;
               }
           }
           if(!TFFormulaInput01.getText().equals(TFF01)){
               if(TFFormulaInput01.getText().isEmpty()){
                   TFFormulaInput01.setText(TFF01);
               }else{
                 v2 = true;
               }
           }
           if(v1 == true & v2 == true){
               TFFormulaInput03.setEditable(false);
               stringTFFormulaInputSum = TFFormulaInput03.getText();
                hadissiyataGahuwe();
               
           }else{
               TFFormulaInput03.setEditable(true);
                TFFormulaInput03.setText("");
           }
       }
    }

    @Override
    public void mousePressed(MouseEvent e) {
   
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int x=JOptionPane.showConfirmDialog(this, "Do you sure close the CalCulator ?", "Exit Windo", JOptionPane.YES_NO_OPTION);
        if(JOptionPane.YES_OPTION==x){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        else if(JOptionPane.NO_OPTION==x){
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}


