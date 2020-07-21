package ServiceRemote;

import javax.ejb.Remote;

import Entities.Commentaire;
@Remote
public interface CommentaireRemote {
	public int ajouterEvaluationSheet(Commentaire commentaire);
}
