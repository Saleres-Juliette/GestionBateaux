import controller.BateauController;
import view.Formulaire;


/**
 * Classe principale d'execution de la Gestion de bateaux
 */
public class GestionDeBateaux {

	public static void main(String[] args) {

		BateauController controller = new BateauController();

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Formulaire.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Formulaire.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Formulaire.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Formulaire.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		/* Creation de la fenetre Swing */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Formulaire(controller).setVisible(true);
			}
		});
	}
}
