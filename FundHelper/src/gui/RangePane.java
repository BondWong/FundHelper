/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.FundInfoManager;
import model.sortMethod.DailyMeanSortMethod;
import model.sortMethod.FiveYearRaiseSortMethod;
import model.sortMethod.HalfYearRaiseSortMethod;
import model.sortMethod.OneYearRaiseSortMethod;
import model.sortMethod.SortMethod;
import model.sortMethod.TwoYearRaiseSortMethod;

/**
 *
 * @author bondwong
 */
public class RangePane extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4340803348400545673L;
	/**
     * Creates new form RangePane
     */
	private static Map<String, SortMethod> SORTMETHOD = new HashMap<String, SortMethod>();
	static{
		SORTMETHOD.put("日均净值增幅排序", new DailyMeanSortMethod());
        SORTMETHOD.put("半年收益排序", new HalfYearRaiseSortMethod());
        SORTMETHOD.put("一年收益排序", new OneYearRaiseSortMethod());
        SORTMETHOD.put("两年收益排序", new TwoYearRaiseSortMethod());
        SORTMETHOD.put("五年收益排序", new FiveYearRaiseSortMethod());
	}
    public RangePane(FundInfoManager fim) {
    	this.fim = fim;
        initComponents(fim.getTypes().toArray());
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Object[] type) {

        fundTypeComboBox = new javax.swing.JComboBox();
        sortMethofComboBox = new javax.swing.JComboBox();
        limitComboBox = new javax.swing.JComboBox();
        fundTypeLabel = new javax.swing.JLabel();
        sortMethodLabel = new javax.swing.JLabel();
        LimitLabel = new javax.swing.JLabel();
        queryButton = new javax.swing.JButton();
        multiRowsDataPane2 = new MultiRowsDataPane(this.fim);
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(400, 195));
        multiRowsDataPane2.setVisible(false);
        
        fundTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(type));
        
        sortMethofComboBox.setModel(new javax.swing.DefaultComboBoxModel(SORTMETHOD.keySet().toArray()));

        limitComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "30", "50", "100", "500" }));
        limitComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limitComboBoxActionPerformed(evt);
            }
        });

        fundTypeLabel.setText("基金类型：");

        sortMethodLabel.setText("排序方式：");

        LimitLabel.setText("基金排名：");

        queryButton.setText("查询");
        queryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                queryButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fundTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fundTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sortMethofComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortMethodLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(queryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LimitLabel)
                    .addComponent(limitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(multiRowsDataPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fundTypeLabel)
                    .addComponent(sortMethodLabel)
                    .addComponent(LimitLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fundTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortMethofComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(queryButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(multiRowsDataPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void limitComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limitComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limitComboBoxActionPerformed

    private void queryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_queryButtonMouseClicked
        // TODO add your handling code here:
        String fundType = (String) fundTypeComboBox.getSelectedItem();
        int limit = Integer.parseInt((String) limitComboBox.getSelectedItem());
        String sortMethod = (String) sortMethofComboBox.getSelectedItem();
        List<String> fundCodes = fim.getSortedFundCodes(fundType, limit, SORTMETHOD.get(sortMethod));
        Object[][] datas = null;
        for(int i=0;i<fundCodes.size();i++){
        	List<String> basicInfo = fim.getBasicInfo(fundCodes.get(i));
        	if(datas==null){
        		datas = new Object[fundCodes.size()][basicInfo.size()];
        	}
        	datas[i] = basicInfo.toArray();
        }
        multiRowsDataPane2.setData(datas);
        multiRowsDataPane2.setVisible(true);
        System.out.println(fundCodes.size() == datas.length);
    }//GEN-LAST:event_queryButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LimitLabel;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox fundTypeComboBox;
    private javax.swing.JLabel fundTypeLabel;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox limitComboBox;
    private javax.swing.JButton queryButton;
    private javax.swing.JLabel sortMethodLabel;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox sortMethofComboBox;
    private MultiRowsDataPane multiRowsDataPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
	private FundInfoManager fim;
}
