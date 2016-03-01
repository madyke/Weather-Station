/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog1;

import java.awt.Dimension;

/**
 *
 * @author cparsons
 */
public class WeatherStationDataApp extends javax.swing.JFrame {

    /**
     * Creates new form WeatherStationDataApp
     */
    public WeatherStationDataApp() {
        //create AppDate objects
        beginDate = new AppDate();
        endDate = new AppDate();
        dateEntered = new AppDate();
        
        //create thermometer objects
        meanTempTherm = new org.jfree.chart.plot.JThermometer();
        highTempTherm = new org.jfree.chart.plot.JThermometer();
        lowTempTherm = new org.jfree.chart.plot.JThermometer();
        rainfallTherm = new org.jfree.chart.plot.JThermometer();
        
        //set the ranges for the thermometer objects
        meanTempTherm.setRange(-30, 110);
        highTempTherm.setRange(-30, 110);
        lowTempTherm.setRange(-30, 110);
        rainfallTherm.setRange(0, 30);
        
        //set the titles for the thermometer objects
        meanTempTherm.addSubtitle("Mean Temp");
        highTempTherm.addSubtitle("High Temp");
        lowTempTherm.addSubtitle("Low Temp");
        rainfallTherm.addSubtitle("Rainfall");
        
        //this is for testing purposes
        meanTempTherm.setValue(25);
        highTempTherm.setValue(25);
        lowTempTherm.setValue(25);
        rainfallTherm.setValue(25);
        
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButtonGroup = new javax.swing.ButtonGroup();
        chooseDateRangeLabel = new javax.swing.JLabel();
        beginDateTextField = new javax.swing.JTextField();
        beginDateLabel = new javax.swing.JLabel();
        dailyRadioButton = new javax.swing.JRadioButton();
        weeklyRadioButton = new javax.swing.JRadioButton();
        monthlyRadioButton = new javax.swing.JRadioButton();
        yearlyRadioButton = new javax.swing.JRadioButton();
        chooseGraphComboBox = new javax.swing.JComboBox<>();
        allDatesButton = new javax.swing.JRadioButton();
        statisticsSectionLabel = new javax.swing.JLabel();
        meanTempLabel = new javax.swing.JLabel();
        highTempLabel = new javax.swing.JLabel();
        lowTempLabel = new javax.swing.JLabel();
        meanWindSpeedLabel = new javax.swing.JLabel();
        prevailingWindDirectionLabel = new javax.swing.JLabel();
        rainfallLabel = new javax.swing.JLabel();
        meanTempValueLabel = new javax.swing.JLabel();
        highTempValueLabel = new javax.swing.JLabel();
        lowTempValueLabel = new javax.swing.JLabel();
        meanWindSpeedValueLabel = new javax.swing.JLabel();
        prevailingWindDirectionValueLabel = new javax.swing.JLabel();
        rainfallValueLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dialDisplayPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        graphDisplayPanel = new GraphPanel("Title");
        appMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        quitMenuItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(681, 469));

        chooseDateRangeLabel.setText("Choose Date:");

        beginDateTextField.setText(beginDate.toString());
        beginDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginDateTextFieldActionPerformed(evt);
            }
        });

        beginDateLabel.setText("Begin");

        radioButtonGroup.add(dailyRadioButton);
        dailyRadioButton.setText("Daily");
        dailyRadioButton.setSelected(true);
        dailyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyRadioButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(weeklyRadioButton);
        weeklyRadioButton.setText("Weekly");
        weeklyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyRadioButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(monthlyRadioButton);
        monthlyRadioButton.setText("Monthly");
        monthlyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyRadioButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(yearlyRadioButton);
        yearlyRadioButton.setText("Yearly");
        yearlyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearlyRadioButtonActionPerformed(evt);
            }
        });

        chooseGraphComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Temperature", "Humidity", "Barometric Pressure", "Wind Speed", "UV Index", "Rainfall" }));
        chooseGraphComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseGraphComboBoxActionPerformed(evt);
            }
        });

        radioButtonGroup.add(allDatesButton);
        allDatesButton.setText("All Dates");

        statisticsSectionLabel.setText("Statistics:");

        meanTempLabel.setText("Mean Temp");

        highTempLabel.setText("High Temp");

        lowTempLabel.setText("Low Temp");

        meanWindSpeedLabel.setText("Mean Wind Speed");

        prevailingWindDirectionLabel.setText("Prevailing Wind Direction");

        rainfallLabel.setText("Rainfall");

        meanTempValueLabel.setText("0");

        highTempValueLabel.setText("0");

        lowTempValueLabel.setText("0");

        meanWindSpeedValueLabel.setText("0");

        prevailingWindDirectionValueLabel.setText("NW");

        rainfallValueLabel.setText("0");

        dialDisplayPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        dialDisplayPanel.setLayout(new java.awt.GridLayout());
        jScrollPane1.setViewportView(dialDisplayPanel);
        meanThermDisplayPanel = new javax.swing.JPanel();
        meanThermDisplayPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        meanTempTherm.setPreferredSize(new java.awt.Dimension(1, 1));
        meanTempTherm.setUnits(1);
        meanThermDisplayPanel.add(meanTempTherm);
        highThermDisplayPanel = new javax.swing.JPanel();
        highThermDisplayPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        highTempTherm.setPreferredSize(new java.awt.Dimension(1, 1));
        highTempTherm.setUnits(1);
        highThermDisplayPanel.add(highTempTherm);
        lowThermDisplayPanel = new javax.swing.JPanel();
        lowThermDisplayPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        lowTempTherm.setPreferredSize(new java.awt.Dimension(1, 1));
        lowTempTherm.setUnits(1);
        lowThermDisplayPanel.add(lowTempTherm);
        rainfallDisplayPanel = new javax.swing.JPanel();
        rainfallDisplayPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        rainfallTherm.setPreferredSize(new java.awt.Dimension(1, 1));
        rainfallTherm.setUnits(0);
        rainfallDisplayPanel.add(rainfallTherm);
        dialDisplayPanel.add(highTempTherm);
        dialDisplayPanel.add(meanTempTherm);
        dialDisplayPanel.add(lowTempTherm);
        dialDisplayPanel.add(rainfallTherm);
        //dialDisplayPanel.add(meanThermDisplayPanel);
        //dialDisplayPanel.add(highThermDisplayPanel);
        //dialDisplayPanel.add(lowThermDisplayPanel);
        //dialDisplayPanel.add(rainfallDisplayPanel);

        graphDisplayPanel.setLayout(new java.awt.GridLayout());
        jScrollPane2.setViewportView(graphDisplayPanel);
        graphDisplayPanel.validate();

        appMenuBar.setName("appMenuBar"); // NOI18N

        fileMenu.setText("File");

        quitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(quitMenuItem);

        appMenuBar.add(fileMenu);

        aboutMenu.setText("About");

        aboutMenuItem.setText("About");
        aboutMenu.add(aboutMenuItem);

        appMenuBar.add(aboutMenu);

        setJMenuBar(appMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chooseDateRangeLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(beginDateLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(beginDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(chooseGraphComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statisticsSectionLabel)
                            .addComponent(allDatesButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dailyRadioButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(weeklyRadioButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(monthlyRadioButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(yearlyRadioButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rainfallLabel)
                                .addGap(18, 18, 18)
                                .addComponent(rainfallValueLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(prevailingWindDirectionLabel)
                                .addGap(18, 18, 18)
                                .addComponent(prevailingWindDirectionValueLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(meanWindSpeedLabel)
                                .addGap(18, 18, 18)
                                .addComponent(meanWindSpeedValueLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lowTempLabel)
                                .addGap(18, 18, 18)
                                .addComponent(lowTempValueLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(highTempLabel)
                                .addGap(18, 18, 18)
                                .addComponent(highTempValueLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(meanTempLabel)
                                .addGap(18, 18, 18)
                                .addComponent(meanTempValueLabel)))
                        .addGap(10, 10, 10))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dailyRadioButton, monthlyRadioButton, weeklyRadioButton, yearlyRadioButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {highTempLabel, lowTempLabel, meanTempLabel, meanWindSpeedLabel, prevailingWindDirectionLabel, rainfallLabel});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {highTempValueLabel, lowTempValueLabel, meanTempValueLabel, meanWindSpeedValueLabel, prevailingWindDirectionValueLabel, rainfallValueLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooseGraphComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(chooseDateRangeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(beginDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(beginDateLabel))
                        .addGap(18, 18, 18)
                        .addComponent(dailyRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weeklyRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthlyRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearlyRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allDatesButton))
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(statisticsSectionLabel)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meanTempLabel)
                            .addComponent(meanTempValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(highTempLabel)
                            .addComponent(highTempValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lowTempLabel)
                            .addComponent(lowTempValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meanWindSpeedLabel)
                            .addComponent(meanWindSpeedValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prevailingWindDirectionLabel)
                            .addComponent(prevailingWindDirectionValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rainfallLabel)
                            .addComponent(rainfallValueLabel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuItemActionPerformed
        //exits the application
        System.exit(0);
    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void monthlyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyRadioButtonActionPerformed
        int tempYear = dateEntered.getYear();
        //set the date ranges to the beginning and end of the month the entered
        //date is in.
        switch(dateEntered.getMonth())
        {
            //January
            case 1:
                beginDate.setMonth(1);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(1);
                endDate.setDay(31);
                endDate.setYear(tempYear);
                break;
            //February
            case 2:
                beginDate.setMonth(2);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(1);
                if(tempYear % 400 == 0)
                {
                   endDate.setDay(29); 
                }
                else if((tempYear % 4 == 0) && (tempYear % 100 != 0))
                {
                    endDate.setDay(29);
                }
                else 
                {
                    endDate.setDay(28);
                }
                endDate.setYear(tempYear);
                break;
            //March
            case 3:
                beginDate.setMonth(3);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(3);
                endDate.setDay(31);
                endDate.setYear(tempYear);
                break;
            //April
            case 4:
                beginDate.setMonth(4);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(4);
                endDate.setDay(30);
                endDate.setYear(tempYear);
                break;
            //May
            case 5:
                beginDate.setMonth(5);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(5);
                endDate.setDay(31);
                endDate.setYear(tempYear);
                break;
            //June
            case 6:
                beginDate.setMonth(6);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(6);
                endDate.setDay(30);
                endDate.setYear(tempYear);
                break;
            //July
            case 7:
                beginDate.setMonth(7);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(7);
                endDate.setDay(31);
                endDate.setYear(tempYear);
                break;
            //August
            case 8:
                beginDate.setMonth(8);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(8);
                endDate.setDay(31);
                endDate.setYear(tempYear);
                break;
            //September
            case 9:
                beginDate.setMonth(9);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(9);
                endDate.setDay(30);
                endDate.setYear(tempYear);
                break;
            //October
            case 10:
                beginDate.setMonth(10);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(10);
                endDate.setDay(31);
                endDate.setYear(tempYear);
                break;
            //November
            case 11:
                beginDate.setMonth(11);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(11);
                endDate.setDay(30);
                endDate.setYear(tempYear);
                break;
            //December
            case 12:
                beginDate.setMonth(12);
                beginDate.setDay(1);
                beginDate.setYear(tempYear);
                
                endDate.setMonth(12);
                endDate.setDay(31);
                endDate.setYear(tempYear);
                break;
        }
        beginDateTextField.setText(dateEntered.toString());
    }//GEN-LAST:event_monthlyRadioButtonActionPerformed

    private void dailyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyRadioButtonActionPerformed
        //set the end date to the same as the begin date
        beginDate.setMonth(dateEntered.getMonth());
        beginDate.setDay(dateEntered.getDay());
        beginDate.setYear(dateEntered.getYear());
        endDate.setMonth(dateEntered.getMonth());
        endDate.setDay(dateEntered.getDay());
        endDate.setYear(dateEntered.getYear());
    }//GEN-LAST:event_dailyRadioButtonActionPerformed

    private void chooseGraphComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseGraphComboBoxActionPerformed
        //display graph for Temperature
        
        //display graph for Humidity
        
        //display graph for Barometric Pressure
        
        //display graph for Wind Speed
        
        //display graph for UV Index
        
        //display graph for Rainfall
        
    }//GEN-LAST:event_chooseGraphComboBoxActionPerformed

    private void beginDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginDateTextFieldActionPerformed
        //get the value entered into the beginDateTextField
        String textField = beginDateTextField.getText();
        int m, d, y; //month, day, year
        boolean isValid = false; //flag for date checking
        //parse the textField string to get the month, day, and year components
        //save those components into the beginDate object
        String [] parsed = textField.split("/");
        //store the values in a temporary variable while error checking
        m = Integer.parseInt(parsed[0]);
        d = Integer.parseInt(parsed[1]);
        y = Integer.parseInt(parsed[2]);
        //checks for valid month and day
        switch(m)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(d > 0 && d <= 31)
                {
                    isValid = true; 
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(d > 0 && d <= 30)
                {
                    isValid = true;
                }
                break;
            case 2:
                if(y % 400 != 0 && y % 4 !=0)
                {
                    if(d > 0 && d <= 28)
                    {
                        isValid = true;
                    }
                }
                else
                {
                    if(d > 0 && d <=29)
                    {
                        isValid = true;
                    }
                }
                break;           
        }
        if(isValid == true)
        {
            dateEntered.setMonth(m);
            dateEntered.setDay(d);
            dateEntered.setYear(y);
        }
        //display the date that was entered by the user
        beginDateTextField.setText(dateEntered.toString());
    }//GEN-LAST:event_beginDateTextFieldActionPerformed

    private void weeklyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyRadioButtonActionPerformed
        //set the end date to be 7 days after the begin date
        beginDate.setMonth(dateEntered.getMonth());
        beginDate.setDay(dateEntered.getDay());
        beginDate.setYear(dateEntered.getYear());
        switch(beginDate.getMonth())
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if(beginDate.getDay() > 25)
                {
                    endDate.setMonth(beginDate.getMonth() + 1);
                    endDate.setDay(6 - (31 - beginDate.getDay()));
                }
                else
                {
                    endDate.setMonth(beginDate.getMonth());
                    endDate.setDay(beginDate.getDay() + 6);
                }
                endDate.setYear(beginDate.getYear());
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(beginDate.getDay() > 24)
                {
                    endDate.setMonth(beginDate.getMonth() + 1);
                    endDate.setDay(6 - (30 - beginDate.getDay()));
                }
                else
                {
                    endDate.setMonth(beginDate.getMonth());
                    endDate.setDay(beginDate.getDay() + 6);
                }
                endDate.setYear(beginDate.getYear());
                break;
            case 2:
                if((beginDate.getDay() > 22) && ((beginDate.getYear() % 4 != 0)
                        || (beginDate.getYear() % 400 != 0 
                        &&  beginDate.getYear() % 100 == 0)))
                {
                    endDate.setMonth(beginDate.getMonth() + 1);
                    endDate.setDay(6 - (28 - beginDate.getDay()));
                }
                else if(beginDate.getDay() > 23)
                {
                    endDate.setMonth(beginDate.getMonth() + 1);
                    endDate.setDay(6 - (29 - beginDate.getDay()));
                }
                else
                {
                    endDate.setMonth(beginDate.getMonth());
                    endDate.setDay(beginDate.getDay() + 6);
                }
                endDate.setYear(beginDate.getYear());
                break;
            case 12:
                if(beginDate.getDay() > 25)
                {
                    endDate.setMonth(1);
                    endDate.setDay(6 - (31 - beginDate.getDay()));
                    endDate.setYear(beginDate.getYear() + 1);
                }
                else
                {
                    endDate.setMonth(beginDate.getMonth());
                    endDate.setDay(beginDate.getDay() + 6);
                    endDate.setYear(beginDate.getYear());
                }
                break;    
        }
        beginDateTextField.setText(dateEntered.toString());
    }//GEN-LAST:event_weeklyRadioButtonActionPerformed

    private void yearlyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearlyRadioButtonActionPerformed
        //set begin and end dates to the first and last days of the year
        beginDate.setMonth(1);
        beginDate.setDay(1);
        beginDate.setYear(dateEntered.getYear());
        
        endDate.setMonth(12);
        endDate.setDay(31);
        endDate.setYear(dateEntered.getYear());
        
        beginDateTextField.setText(dateEntered.toString());
    }//GEN-LAST:event_yearlyRadioButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherStationDataApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherStationDataApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherStationDataApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherStationDataApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //Parse file
        XMLParse.parseFiles();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherStationDataApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JRadioButton allDatesButton;
    private javax.swing.JMenuBar appMenuBar;
    private javax.swing.JLabel beginDateLabel;
    private javax.swing.JTextField beginDateTextField;
    private javax.swing.JLabel chooseDateRangeLabel;
    private javax.swing.JComboBox<String> chooseGraphComboBox;
    private javax.swing.JRadioButton dailyRadioButton;
    private javax.swing.JPanel dialDisplayPanel;
    private javax.swing.JPanel meanThermDisplayPanel;
    private javax.swing.JPanel highThermDisplayPanel;
    private javax.swing.JPanel lowThermDisplayPanel;
    private javax.swing.JPanel rainfallDisplayPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel graphDisplayPanel;
    private javax.swing.JLabel highTempLabel;
    private javax.swing.JLabel highTempValueLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lowTempLabel;
    private javax.swing.JLabel lowTempValueLabel;
    private javax.swing.JLabel meanTempLabel;
    private javax.swing.JLabel meanTempValueLabel;
    private javax.swing.JLabel meanWindSpeedLabel;
    private javax.swing.JLabel meanWindSpeedValueLabel;
    private javax.swing.JRadioButton monthlyRadioButton;
    private javax.swing.JLabel prevailingWindDirectionLabel;
    private javax.swing.JLabel prevailingWindDirectionValueLabel;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.ButtonGroup radioButtonGroup;
    private javax.swing.JLabel rainfallLabel;
    private javax.swing.JLabel rainfallValueLabel;
    private javax.swing.JLabel statisticsSectionLabel;
    private javax.swing.JRadioButton weeklyRadioButton;
    private javax.swing.JRadioButton yearlyRadioButton;
    // End of variables declaration//GEN-END:variables
    //Non-generated variable declation
    private AppDate beginDate;
    private AppDate endDate;
    private AppDate dateEntered;
    private org.jfree.chart.plot.JThermometer meanTempTherm;
    private org.jfree.chart.plot.JThermometer highTempTherm;
    private org.jfree.chart.plot.JThermometer lowTempTherm;
    private org.jfree.chart.plot.JThermometer rainfallTherm;
    //End of non-generated variable declaration
}
