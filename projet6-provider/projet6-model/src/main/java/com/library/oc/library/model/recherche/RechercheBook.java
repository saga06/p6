package com.library.oc.library.model.recherche;

public class RechercheBook {
    /**
     * Classe de critères de recherche de Ticket.
     *
     * @author sga
     */
        // ==================== Attributs ====================
        private Integer bookId;
        private Integer auteurId;


        // ==================== Constructeurs ====================
        /**
         * Constructeur par défaut.
         */
        public RechercheBook() {

        }


        // ==================== Getters/Setters ====================
        public Integer getAuteurId() {
            return auteurId;
        }

        /**
         * Assigne le critère de recherche : id de l'auteur.
         *
         * @param pAuteurId -
         * @return {@code this}
         */
        public RechercheBook setAuteurId(Integer pAuteurId) {
            auteurId = pAuteurId;
            return this;
        }

        public Integer getProjetId() {
            return bookId;
        }

        /**
         * Assigne le critère de recherche : id du book.
         *
         * @param pBookId -
         * @return {@code this}
         */
        public RechercheBook setBookId(Integer pBookId) {
            bookId = pBookId;
            return this;
        }
    }

