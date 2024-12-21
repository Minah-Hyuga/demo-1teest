package exam.data.repository;

// import exam.data.entities.Commande;
// import exam.data.entities.Article;
// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.cfg.Configuration;
// import java.util.List;

// public class CommandeRepository {

// private SessionFactory factory;

// public CommandeRepository() {
// factory = new Configuration()
// .configure("hibernate.cfg.xml")
// .addAnnotatedClass(Commande.class)
// .addAnnotatedClass(Article.class)
// .buildSessionFactory();
// }

// // Rechercher une commande par ID
// public Commande getCommandeById(int id) {
// Session session = factory.getCurrentSession();
// try {
// session.beginTransaction();
// Commande commande = session.get(Commande.class, id);
// session.getTransaction().commit();
// return commande;
// } finally {
// factory.close();
// }
// }

// // Sauvegarder une commande
// public void saveCommande(Commande commande) {
// Session session = factory.getCurrentSession();
// try {
// session.beginTransaction();
// session.saveOrUpdate(commande); // Sauvegarder ou mettre à jour
// session.getTransaction().commit();
// } finally {
// factory.close();
// }
// }

// // Ajouter un article à la commande
// public void addArticleToCommande(int commandeId, Article article, int
// quantity) {
// Session session = factory.getCurrentSession();
// try {
// session.beginTransaction();
// Commande commande = session.get(Commande.class, commandeId);
// if (commande != null) {
// commande.addArticle(article, quantity); // Méthode à ajouter à votre classe
// Commande pour gérer la liste
// // des articles
// session.saveOrUpdate(commande);
// }
// session.getTransaction().commit();
// } finally {
// factory.close();
// }
// }

// // Supprimer un article de la commande
// public void removeArticleFromCommande(int commandeId, int articleId) {
// Session session = factory.getCurrentSession();
// try {
// session.beginTransaction();
// Commande commande = session.get(Commande.class, commandeId);
// if (commande != null) {
// commande.removeArticle(articleId); // Méthode à ajouter à votre classe
// Commande
// session.saveOrUpdate(commande);
// }
// session.getTransaction().commit();
// } finally {
// factory.close();
// }
// }

// // Mettre à jour une commande (par exemple, changer le prix ou la quantité
// des
// // articles)
// public void updateCommande(Commande commande) {
// Session session = factory.getCurrentSession();
// try {
// session.beginTransaction();
// session.update(commande); // Mise à jour
// session.getTransaction().commit();
// } finally {
// factory.close();
// }
// }

// // Rechercher toutes les commandes d'un client (par téléphone par exemple)
// public List<Commande> getCommandesByClient(String telephone) {
// Session session = factory.getCurrentSession();
// try {
// session.beginTransaction();
// List<Commande> commandes = session
// .createQuery("from Commande where client.telephone=:telephone",
// Commande.class)
// .setParameter("telephone", telephone)
// .getResultList();
// session.getTransaction().commit();
// return commandes;
// } finally {
// factory.close();
// }
// }
// }

import java.util.List;

import exam.data.entities.Commande;
import jakarta.persistence.EntityManager;

public class CommandeRepository {
    private EntityManager em;

    public CommandeRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Commande commande) {
        em.getTransaction().begin();
        if (commande.getId() == null) {
            em.persist(commande);
        } else {
            em.merge(commande);
        }
        em.getTransaction().commit();
    }
}