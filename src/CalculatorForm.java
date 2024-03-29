import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CalculatorForm.java
 *
 * Created on Aug 23, 2011, 5:50:19 AM
 */

/**
 *
 * @author Palmer
 */
public class CalculatorForm extends javax.swing.JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Creates new form CalculatorForm */
    public CalculatorForm() {
        initComponents();
    }

    // End of variables declaration//GEN-END:variables
    
    /**
     * Processes Button input
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String task = e.getActionCommand();
		
		if(task.matches("[\\d,.]"))									//task contains a digit
			displayNumber(task);
		else if(task.matches("[/,*,+,-]"))							//task contaions a mathematical operation
			performOperation(task);
		if(task.equals("+/-")){										//task contains a negation
			double number = Double.parseDouble(this.jtxtFldDisplay.getText());
			number -=(2 * number);
			this.jtxtFldDisplay.setText(Integer.toString((int)number));			
		}
		if(task.equals("%")){										//percentage task
			double number = Double.parseDouble(this.jtxtFldDisplay.getText());
			number /= 100;
			this.jtxtFldDisplay.setText(Double.toString(number));
		}
		if(task.equals("sqrt")){									//square root task
			double number = Double.parseDouble(this.jtxtFldDisplay.getText());
			number = Math.sqrt(number);
			this.jtxtFldDisplay.setText(Double.toString(number));
		}
		if(task.equals("1/X")){										//inverse task
			double number = Integer.parseInt(this.jtxtFldDisplay.getText());
			number = 1 / number ;
			this.jtxtFldDisplay.setText(Double.toString(number));
		}
		if(task.matches("M[CR+-]"))									//memory task
			performMemoryOp(task);
		if(task.equals("="))										//equals task
			calculate();
		if(task.equals("Exit"))										//exit program
			System.exit(EXIT_ON_CLOSE);
		if(task.equals("Backspace")){								//remove last digit
			String number = this.jtxtFldDisplay.getText();
			if(number.length() > 1)
				number = number.substring(0, number.length()- 1);
			else{
				number = "0";
				firstNumber = true;
			}
			this.jtxtFldDisplay.setText(number);
		}
		if(task.equals("C")){										//clear current number
			this.jtxtFldDisplay.setText("0");
			firstNumber = true;
		}
		if(task.equals("CE")){										//clear everything
			this.jtxtFldDisplay.setText("0");
			total = 0;
			firstNumber = true;
		}
	}//end actionPerformed

	/**
	 * Displays the calculation based on the current operation
	 */
	private void calculate() {
		if(operation.equals("+")){
			
			//get the currently displayed number and add it total
			total += Double.parseDouble(this.jtxtFldDisplay.getText());			
		}
		else if(operation.equals("-")){
			//get the currently displayed number and add it total
			total -= Double.parseDouble(this.jtxtFldDisplay.getText());
	}
		
		else if(operation.equals("*")){
			//get the currently displayed number and multiply it total
			total *= Double.parseDouble(this.jtxtFldDisplay.getText());
		}
		
		else if(operation.equals("/")){
			//get the currently displayed number and multiply it total
			total /= Double.parseDouble(this.jtxtFldDisplay.getText());
		}
		
		//display the result
		this.jtxtFldDisplay.setText(Double.toString(total));
		//set firstNumber to true
		firstNumber = true;
		//clear operation
		operation = "";
	}//end calculate

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void initComponents() {
	
	    jPanel1 = new javax.swing.JPanel();
	    jbtn7 = new javax.swing.JButton();
	    jbtn8 = new javax.swing.JButton();
	    jbtnDecimal = new javax.swing.JButton();
	    jbtn9 = new javax.swing.JButton();
	    jbtn6 = new javax.swing.JButton();
	    jbtn5 = new javax.swing.JButton();
	    jbtn4 = new javax.swing.JButton();
	    jbtnNegate = new javax.swing.JButton();
	    jbtn2 = new javax.swing.JButton();
	    jbtn1 = new javax.swing.JButton();
	    jbtn0 = new javax.swing.JButton();
	    jbtn3 = new javax.swing.JButton();
	    jbtnDivision = new javax.swing.JButton();
	    jbtnMultiply = new javax.swing.JButton();
	    jbtnAdd = new javax.swing.JButton();
	    jbtnSubtract = new javax.swing.JButton();
	    jbtnSquareRoot = new javax.swing.JButton();
	    jbtnPercent = new javax.swing.JButton();
	    jbtnInverse = new javax.swing.JButton();
	    jbtnEquals = new javax.swing.JButton();
	    jbtnMemClear = new javax.swing.JButton();
	    jbtnMemRecall = new javax.swing.JButton();
	    jbtnMemAdd = new javax.swing.JButton();
	    jbtnMemSubtract = new javax.swing.JButton();
	    jlblMemoryStatus = new javax.swing.JLabel();
	    jbtnBackspace = new javax.swing.JButton();
	    jbtnClear = new javax.swing.JButton();
	    jbtnClearEverything = new javax.swing.JButton();
	    jtxtFldDisplay = new javax.swing.JTextField();
	    jmbMenus = new javax.swing.JMenuBar();
	    jmFile = new javax.swing.JMenu();
	    jmiExit = new javax.swing.JMenuItem();
	    
	    
	    total = 0;
	    memory = 0;
	    firstNumber = true;
	
	    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    setTitle("Calculator");
	
	    jbtn7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn7.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn7.setText("7");
	    jbtn7.addActionListener(this);
	
	    jbtn8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn8.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn8.setText("8");
	    jbtn8.addActionListener(this);
	
	    jbtnDecimal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnDecimal.setForeground(new java.awt.Color(0, 0, 255));
	    jbtnDecimal.setText(".");
	    jbtnDecimal.addActionListener(this);
	
	    jbtn9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn9.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn9.setText("9");
	    jbtn9.addActionListener(this);
	    
	    jbtn6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn6.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn6.setText("6");
	    jbtn6.addActionListener(this);
	    
	    jbtn5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn5.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn5.setText("5");
	    jbtn5.addActionListener(this);
	
	    jbtn4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn4.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn4.setText("4");
	    jbtn4.addActionListener(this);
	
	    jbtnNegate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
	    jbtnNegate.setForeground(new java.awt.Color(0, 0, 255));
	    jbtnNegate.setText("+/-");
	    jbtnNegate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    jbtnNegate.setIconTextGap(3);
	    jbtnNegate.setMargin(new java.awt.Insets(2, 2, 2, 2));
	    jbtnNegate.addActionListener(this);
	    
	
	    jbtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn2.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn2.setText("2");
	    jbtn2.addActionListener(this);
	
	    jbtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn1.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn1.setText("1");
	    jbtn1.addActionListener(this);
	
	    jbtn0.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn0.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn0.setText("0");
	    jbtn0.addActionListener(this);
	
	    jbtn3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtn3.setForeground(new java.awt.Color(0, 0, 255));
	    jbtn3.setText("3");
	    jbtn3.addActionListener(this);
	
	    jbtnDivision.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnDivision.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnDivision.setText("/");
	    jbtnDivision.addActionListener(this);
	
	    jbtnMultiply.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnMultiply.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnMultiply.setText("*");
	    jbtnMultiply.addActionListener(this);                
	
	    jbtnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnAdd.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnAdd.setText("+");
	    jbtnAdd.addActionListener(this);
	
	    jbtnSubtract.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnSubtract.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnSubtract.setText("-");
	    jbtnSubtract.addActionListener(this);
	
	    jbtnSquareRoot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnSquareRoot.setForeground(new java.awt.Color(0, 0, 255));
	    jbtnSquareRoot.setText("sqrt");
	    jbtnSquareRoot.setMargin(new java.awt.Insets(2, 2, 2, 2));
	    jbtnSquareRoot.addActionListener(this);
	
	    jbtnPercent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnPercent.setForeground(new java.awt.Color(0, 0, 255));
	    jbtnPercent.setText("%");
	    jbtnPercent.addActionListener(this);
	
	    jbtnInverse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnInverse.setForeground(new java.awt.Color(0, 0, 255));
	    jbtnInverse.setText("1/X");
	    jbtnInverse.setMargin(new java.awt.Insets(2, 2, 2, 2));
	    jbtnInverse.addActionListener(this);
	
	    jbtnEquals.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnEquals.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnEquals.setText("=");
	    jbtnEquals.addActionListener(this);
	
	    jbtnMemClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnMemClear.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnMemClear.setText("MC");
	    jbtnMemClear.addActionListener(this);
	
	    jbtnMemRecall.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnMemRecall.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnMemRecall.setText("MR");
	    jbtnMemRecall.addActionListener(this);
	
	    jbtnMemAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnMemAdd.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnMemAdd.setText("M+");
	    jbtnMemAdd.addActionListener(this);
	
	    jbtnMemSubtract.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
	    jbtnMemSubtract.setForeground(new java.awt.Color(255, 0, 0));
	    jbtnMemSubtract.setText("M-");
	    jbtnMemSubtract.addActionListener(this);
	
	    jlblMemoryStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
	    jlblMemoryStatus.setMinimumSize(new java.awt.Dimension(32, 32));
	
	    jbtnBackspace.setText("Backspace");
	    jbtnBackspace.addActionListener(this);
	
	    jbtnClear.setText("C");
	    jbtnClear.addActionListener(this);
	
	    jbtnClearEverything.setText("CE");
	    jbtnClearEverything.addActionListener(this);
	
	    jtxtFldDisplay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	    jtxtFldDisplay.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
	    jtxtFldDisplay.setText("0");
	    jtxtFldDisplay.setEditable(false);
	    
	
	    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	    jPanel1.setLayout(jPanel1Layout);
	    jPanel1Layout.setHorizontalGroup(
	        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(jPanel1Layout.createSequentialGroup()
	            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(jPanel1Layout.createSequentialGroup()
	                    .addGap(81, 81, 81)
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(jPanel1Layout.createSequentialGroup()
	                            .addGap(3, 3, 3)
	                            .addComponent(jbtnMemClear)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jbtnMemRecall)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jbtnMemAdd)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jbtnMemSubtract))
	                        .addGroup(jPanel1Layout.createSequentialGroup()
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                .addComponent(jbtnNegate, 0, 0, Short.MAX_VALUE)
	                                .addComponent(jbtn1))
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addGroup(jPanel1Layout.createSequentialGroup()
	                                    .addComponent(jbtn0)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jbtnDecimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                                .addGroup(jPanel1Layout.createSequentialGroup()
	                                    .addComponent(jbtn2)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jbtn3)))
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(jbtnSubtract)
	                                .addComponent(jbtnAdd))
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(jbtnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jbtnInverse, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
	                                .addComponent(jbtn4)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jbtn5)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jbtn6)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jbtnMultiply)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jbtnPercent))
	                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
	                                .addComponent(jbtn7)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jbtn8)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jbtn9)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jbtnDivision)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jbtnSquareRoot, 0, 0, Short.MAX_VALUE)))
	                        .addGroup(jPanel1Layout.createSequentialGroup()
	                            .addComponent(jbtnBackspace)
	                            .addGap(18, 18, 18)
	                            .addComponent(jbtnClearEverything, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGap(20, 20, 20)
	                            .addComponent(jbtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGap(22, 22, 22)
	                    .addComponent(jlblMemoryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGroup(jPanel1Layout.createSequentialGroup()
	                    .addGap(43, 43, 43)
	                    .addComponent(jtxtFldDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
	            .addContainerGap(44, Short.MAX_VALUE))
	    );
	    jPanel1Layout.setVerticalGroup(
	        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	            .addContainerGap(42, Short.MAX_VALUE)
	            .addComponent(jtxtFldDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addGap(33, 33, 33)
	            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                .addComponent(jlblMemoryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGroup(jPanel1Layout.createSequentialGroup()
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(jbtnBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnClear)
	                        .addComponent(jbtnClearEverything))
	                    .addGap(18, 18, 18)
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(jbtnMemSubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnMemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnMemRecall, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnMemClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addComponent(jbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGroup(jPanel1Layout.createSequentialGroup()
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(jbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jbtnDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jbtnSquareRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(jbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jbtnMultiply, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addComponent(jbtnPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                    .addGap(9, 9, 9)
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(jbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnInverse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(jbtnNegate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtn0, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnDecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnSubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(jbtnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
	            .addGap(22, 22, 22))
	    );
	
	    jmFile.setText("File");
	
	    jmiExit.setText("Exit");
	    jmiExit.addActionListener(this);
	    jmFile.add(jmiExit);
	
	    jmbMenus.add(jmFile);
	
	    
	    
	
	    setJMenuBar(jmbMenus);
	
	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(
	        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	            .addContainerGap()
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addContainerGap())
	    );
	    layout.setVerticalGroup(
	        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	        .addGroup(layout.createSequentialGroup()
	            .addContainerGap()
	            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addContainerGap(13, Short.MAX_VALUE))
	    );
	
	    pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Performs operations associated with Memory
	 * @param task
	 */
	private void performMemoryOp(String task) {
		// TODO Auto-generated method stub
		if(task.matches("M[+-]"))												//indicate active memory
			this.jlblMemoryStatus.setText("M");
		
		if(task.equals("MC")){												//indicate inactive memory
			this.jlblMemoryStatus.setText("");
			memory = 0;
		}
		
		if(task.equals("M+")){												//add to memory
			double number = Double.parseDouble(this.jtxtFldDisplay.getText());
			memory += number;
		}
		if(task.equals("M-")){												//subtract from memory			
			double number = Double.parseDouble(this.jtxtFldDisplay.getText());
			memory -= number;
		}
		
		if(task.equals("MR")){												//display memory
			this.jtxtFldDisplay.setText(Double.toString(memory));
		}
	}//end performMemoryOp

	/**
	 * Sets the current mathematical operation
	 * @param task
	 */
	private void performOperation(String task) {
		// TODO Auto-generated method stub
		operation = task;
		//get the currently displayed number and add it total
		total = Double.parseDouble(this.jtxtFldDisplay.getText());
		//set firstNumber to true
		firstNumber = true;
		
	}//end performOperation(String)

	/**
	 * Display the currently pressed button number on the screen
	 * @param task
	 */
	private void displayNumber(String task) {
		// TODO Auto-generated method stub
		if(!firstNumber)
			this.jtxtFldDisplay.setText(this.jtxtFldDisplay.getText().concat(task));
		else{
			this.jtxtFldDisplay.setText(task);
			firstNumber = false;
		}
	}//end displayNumber

	/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new CalculatorForm().setVisible(true);
            }
        });
    }//end main
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtn0;
    private javax.swing.JButton jbtn1;
    private javax.swing.JButton jbtn2;
    private javax.swing.JButton jbtn3;
    private javax.swing.JButton jbtn4;
    private javax.swing.JButton jbtn5;
    private javax.swing.JButton jbtn6;
    private javax.swing.JButton jbtn7;
    private javax.swing.JButton jbtn8;
    private javax.swing.JButton jbtn9;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnBackspace;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnClearEverything;
    private javax.swing.JButton jbtnDecimal;
    private javax.swing.JButton jbtnDivision;
    private javax.swing.JButton jbtnEquals;
    private javax.swing.JButton jbtnMemClear;
    private javax.swing.JButton jbtnMemRecall;
    private javax.swing.JButton jbtnMemAdd;
    private javax.swing.JButton jbtnMemSubtract;
    private javax.swing.JButton jbtnInverse;
    private javax.swing.JButton jbtnMultiply;
    private javax.swing.JButton jbtnNegate;
    private javax.swing.JButton jbtnPercent;
    private javax.swing.JButton jbtnSquareRoot;
    private javax.swing.JButton jbtnSubtract;
    private javax.swing.JLabel jlblMemoryStatus;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuBar jmbMenus;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JTextField jtxtFldDisplay;
    
    private double total;
    private double memory;
    private boolean firstNumber;
    private String operation;
}//end CalculatorForm
