/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Rakesh
 */
public abstract class ClientWindow extends javax.swing.JFrame {

	/**
	 * Creates new form ClientWindow
	 */
	public ClientWindow() {
		initComponents();
		setVisible(true);
	}
	public String onGetMAC() {
		return null;
	}
	public String onGetIP() {
		return null;
	}
	public String getIP() {
		return txt_ip.getText();
	}
	public String getMAC() {
		return txt_mac.getText();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ip = new javax.swing.JTextField();
        txt_mac = new javax.swing.JTextField();
        btn_getmac = new javax.swing.JButton();
        btn_getip = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ARP/RARP");
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setText("IP");

        jLabel2.setText("MAC");

        txt_ip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ipKeyTyped(evt);
            }
        });

        txt_mac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_macKeyTyped(evt);
            }
        });

        btn_getmac.setText("get MAC");
        btn_getmac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getmacActionPerformed(evt);
            }
        });

        btn_getip.setText("get IP");
        btn_getip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ip, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(txt_mac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_getmac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_getip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_getmac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_mac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_getip))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btn_getmacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getmacActionPerformed
		txt_mac.setText(onGetMAC());
	}//GEN-LAST:event_btn_getmacActionPerformed

	private void txt_ipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ipKeyTyped
		if(evt.getKeyChar()=='\n')
			btn_getmac.doClick();
	}//GEN-LAST:event_txt_ipKeyTyped

    private void btn_getipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getipActionPerformed
		txt_ip.setText(onGetIP());
    }//GEN-LAST:event_btn_getipActionPerformed

    private void txt_macKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_macKeyTyped
        if(evt.getKeyChar()=='\n')
			btn_getip.doClick();
    }//GEN-LAST:event_txt_macKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_getip;
    private javax.swing.JButton btn_getmac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txt_ip;
    private javax.swing.JTextField txt_mac;
    // End of variables declaration//GEN-END:variables
}
