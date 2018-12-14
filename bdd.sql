--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: author; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.author (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.author OWNER TO postgres;

--
-- Name: author_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.author_id_seq OWNER TO postgres;

--
-- Name: author_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.author_id_seq OWNED BY public.author.id;


--
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    id integer NOT NULL,
    number_of_copies integer NOT NULL,
    title character varying(100) NOT NULL,
    editor_id integer NOT NULL,
    isbn character varying(50) NOT NULL,
    resume text
);


ALTER TABLE public.book OWNER TO postgres;

--
-- Name: book_author; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book_author (
    author_id integer NOT NULL,
    book_id integer NOT NULL
);


ALTER TABLE public.book_author OWNER TO postgres;

--
-- Name: book_theme; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book_theme (
    book_id integer NOT NULL,
    theme_id integer NOT NULL
);


ALTER TABLE public.book_theme OWNER TO postgres;

--
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_id_seq OWNER TO postgres;

--
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.book.id;


--
-- Name: borrow; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.borrow (
    id_borrow integer NOT NULL,
    date_start date NOT NULL,
    date_end date NOT NULL,
    already_extended boolean DEFAULT false NOT NULL,
    id_borrower integer NOT NULL,
    id_book integer NOT NULL,
    is_returned boolean DEFAULT false NOT NULL,
    is_returned_on_time boolean DEFAULT false
);


ALTER TABLE public.borrow OWNER TO postgres;

--
-- Name: COLUMN borrow.already_extended; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.borrow.already_extended IS 'We want to know is the borrower already extented the duration of his loan once or not';


--
-- Name: borrow_borrow_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.borrow_borrow_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.borrow_borrow_id_seq OWNER TO postgres;

--
-- Name: borrow_borrow_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.borrow_borrow_id_seq OWNED BY public.borrow.id_borrow;


--
-- Name: config; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.config (
    url character varying(70) NOT NULL,
    password_admin character varying(100) NOT NULL,
    smtp character varying(100) NOT NULL,
    url_webservice character varying(100) NOT NULL,
    id_admin character varying(40) NOT NULL
);


ALTER TABLE public.config OWNER TO postgres;

--
-- Name: editor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.editor (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.editor OWNER TO postgres;

--
-- Name: editor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.editor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.editor_id_seq OWNER TO postgres;

--
-- Name: editor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.editor_id_seq OWNED BY public.editor.id;


--
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id_reservation integer NOT NULL,
    id_book integer NOT NULL,
    id_user integer NOT NULL,
    date_of_reservation timestamp with time zone NOT NULL,
    is_active boolean DEFAULT true NOT NULL,
    email_send boolean DEFAULT false NOT NULL,
    datetime_email_send timestamp with time zone
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- Name: COLUMN reservation.is_active; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.reservation.is_active IS 'un status actif signifie que la demande de réservation est tjs d''actualité.';


--
-- Name: COLUMN reservation.email_send; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.reservation.email_send IS 'Savoir si un email a été envoyé à l''utilisateur ';


--
-- Name: COLUMN reservation.datetime_email_send; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.reservation.datetime_email_send IS 'Savoir à quelle moment a été envoyé l''email à l''utilisateur';


--
-- Name: reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.reservation_id_seq OWNER TO postgres;

--
-- Name: reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id_reservation;


--
-- Name: theme; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.theme (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.theme OWNER TO postgres;

--
-- Name: theme_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.theme_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.theme_id_seq OWNER TO postgres;

--
-- Name: theme_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.theme_id_seq OWNED BY public.theme.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    surname character varying(30) NOT NULL,
    lastname character varying NOT NULL,
    email character varying(40) NOT NULL,
    password character varying(100) NOT NULL,
    reminder_active boolean DEFAULT true NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: COLUMN users.reminder_active; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.users.reminder_active IS 'Possibility to active or not an reminder for book late 5 days';


--
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_user_id_seq OWNER TO postgres;

--
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.id;


--
-- Name: author id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author ALTER COLUMN id SET DEFAULT nextval('public.author_id_seq'::regclass);


--
-- Name: book id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- Name: borrow id_borrow; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.borrow ALTER COLUMN id_borrow SET DEFAULT nextval('public.borrow_borrow_id_seq'::regclass);


--
-- Name: editor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editor ALTER COLUMN id SET DEFAULT nextval('public.editor_id_seq'::regclass);


--
-- Name: reservation id_reservation; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN id_reservation SET DEFAULT nextval('public.reservation_id_seq'::regclass);


--
-- Name: theme id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.theme ALTER COLUMN id SET DEFAULT nextval('public.theme_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_user_id_seq'::regclass);


--
-- Data for Name: author; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.author (id, name) FROM stdin;
1	Corneille
2	Shakespeare
3	Flaubert
4	Stendhal
5	Rousseau
6	Michel Le Bellac
7	Claude Cohen Tannoudji
8	Franck Laloë
\.


--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (id, number_of_copies, title, editor_id, isbn, resume) FROM stdin;
1	5	Le Cid	1	208141144X	De conception traditionnelle, cette collection a le mérite d'aborder l'œuvre intégrale sous des angles diversifiés. Outre le résumé détaillé des différentes parties et les commentaires composés qui le complètent, chaque ouvrage propose une synthèse littéraire assez riche : il y est question de l'auteur, des personnages, de la genèse et de l'architecture de l'œuvre mais aussi de ses particularités stylistiques, des réseaux d'intertextualité et des interprétations pos... 
2	6	Roméo et Juliette	1	2081303094	L'action se passe à Vérone et met en scène deux grandes familles ennemies, les Montaigu et les Capulet. À un bal masqué donné par les Capulet, Roméo, un Montaigu, tombe follement amoureux de Juliette, une Capulet promise en mariage au comte Paris, un jeune noble. Il la retrouve à la nuit tombée, sous son balcon, pour lui déclarer son amour. Éperdument amoureux, ils demandent le lendemain au frère Laurent de les marier. Mais leur bonheur sera bref...
7	2	Physique Quantique Tome II	5	2759808041	Les phytotechnologies appliquées à la gestion des sites contaminés regroupent l'ensemble des techniques utilisant des plantes; avec ou sans combinaison à des amendements; pour immobiliser; extraire ou dégrader les polluants du sol. Ces techniques peuvent être une alternative; pour des sites de grande ampleur; à la gestion par des techniques dites classiques (excavation; confinement; lavage...); en raison des volumes importants à traiter et des coûts associés.
6	3	Le Rouge et le Noir	4	2253006203	Fils de charpentier, Julien Sorel est trop sensible et trop ambitieux pour suivre la carrière familiale dans la scierie d’une petite ville de province. En secret, il rêve d’une ascension similaire à celle de Napoléon Bonaparte. Julien trouve une place de précepteur dans la maison du maire, Monsieur de Rénal, et noue une relation interdite avec son épouse. Jusqu’au bout, Julien Sorel verra ses ambitions contrecarrées par ses sentiments, qui les conduiront à sa perte.
3	4	Les confessions	2	2070393933	«Je forme une entreprise qui n'eut jamais d'exemple et dont l'exécution n'aura point d'imitateur. Je veux montrer à mes semblables un homme dans toute la vérité de la nature ; et cet homme ce sera moi.\nMoi, seul. Je sens mon cœur et je connais les hommes. Je ne suis fait comme aucun de ceux que j'ai vus ; j'ose croire n'être fait comme aucun de ceux qui existent. Si je ne vaux pas mieux, au moins je suis autre. Si la nature a bien ou mal fait de briser le m...
4	2	Madame Bovary	2	207041311X 	C'est l'histoire d'une femme mal mariée, de son médiocre époux, de ses amants égoïstes et vains, de ses rêves, de ses chimères, de sa mort. C'est l'histoire d'une province étroite, dévote et bourgeoise. C'est, aussi, l'histoire du roman français. Rien, dans ce tableau, n'avait de quoi choquer la société du Second Empire. Mais, inexorable comme une tragédie, flamboyant comme un drame, mordant comme une comédie, le livre s'était donné une arme redoutable : le style. P... 
\.


--
-- Data for Name: book_author; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book_author (author_id, book_id) FROM stdin;
1	1
2	2
5	3
3	4
4	6
6	7
7	7
8	7
\.


--
-- Data for Name: book_theme; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book_theme (book_id, theme_id) FROM stdin;
1	2
1	5
1	9
2	2
2	5
2	1
2	10
3	11
3	9
3	5
4	12
4	5
4	9
4	4
6	12
6	5
6	9
7	13
7	14
7	15
7	16
\.


--
-- Data for Name: borrow; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.borrow (id_borrow, date_start, date_end, already_extended, id_borrower, id_book, is_returned, is_returned_on_time) FROM stdin;
\.


--
-- Data for Name: config; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.config (url, password_admin, smtp, url_webservice, id_admin) FROM stdin;
\.


--
-- Data for Name: editor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.editor (id, name) FROM stdin;
3	POCKET
1	FLAMMARION
2	GALLIMARD
4	Le Livre De Poche
5	CNRS Edition
\.


--
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id_reservation, id_book, id_user, date_of_reservation, is_active, email_send, datetime_email_send) FROM stdin;
\.


--
-- Data for Name: theme; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.theme (id, name) FROM stdin;
1	Tragédie
2	Théâtre
3	Drame
4	Amour
5	Classique
7	Vengeance
8	Duel
9	Littérature Française
10	Littérature Anglaise
11	Autobiographique
12	Roman
13	Educatif
14	Enseignement
15	Recherche
16	Physique
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, surname, lastname, email, password, reminder_active) FROM stdin;
1	Hubert	Jean	samirgahama@gmail.com	$2a$10$qMWyYgXF9Su3w9GwS7zoyOQYt9uFYr9/X07g/ssib201IQrmC3ip6	t
3	Steve	Alfred	test@test.com	$2a$10$qMWyYgXF9Su3w9GwS7zoyOQYt9uFYr9/X07g/ssib201IQrmC3ip6	f
5	Samir	Gahama	samirgahama@hotmail.com	$2a$10$qMWyYgXF9Su3w9GwS7zoyOQYt9uFYr9/X07g/ssib201IQrmC3ip6	t
\.


--
-- Name: author_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.author_id_seq', 8, true);


--
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_id_seq', 7, true);


--
-- Name: borrow_borrow_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.borrow_borrow_id_seq', 85, true);


--
-- Name: editor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.editor_id_seq', 5, true);


--
-- Name: reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_seq', 33, true);


--
-- Name: theme_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.theme_id_seq', 16, true);


--
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_user_id_seq', 6, true);


--
-- Name: author author_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (id);


--
-- Name: book books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- Name: borrow borrow_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.borrow
    ADD CONSTRAINT borrow_pk PRIMARY KEY (id_borrow);


--
-- Name: editor editor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editor
    ADD CONSTRAINT editor_pkey PRIMARY KEY (id);


--
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id_reservation);


--
-- Name: theme theme_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.theme
    ADD CONSTRAINT theme_pkey PRIMARY KEY (id);


--
-- Name: users users_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pk PRIMARY KEY (id);


--
-- Name: book_author book_author_author_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT book_author_author_id_fkey FOREIGN KEY (author_id) REFERENCES public.author(id);


--
-- Name: book_author book_author_book_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT book_author_book_id_fkey FOREIGN KEY (book_id) REFERENCES public.book(id);


--
-- Name: book book_editor_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_editor_id_fkey FOREIGN KEY (editor_id) REFERENCES public.editor(id);


--
-- Name: book_theme book_theme_book_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_theme
    ADD CONSTRAINT book_theme_book_id_fkey FOREIGN KEY (book_id) REFERENCES public.book(id);


--
-- Name: book_theme book_theme_theme_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_theme
    ADD CONSTRAINT book_theme_theme_id_fkey FOREIGN KEY (theme_id) REFERENCES public.theme(id);


--
-- Name: borrow borrow_id_book_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.borrow
    ADD CONSTRAINT borrow_id_book_fkey FOREIGN KEY (id_book) REFERENCES public.book(id);


--
-- Name: borrow borrow_id_borrower_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.borrow
    ADD CONSTRAINT borrow_id_borrower_fkey FOREIGN KEY (id_borrower) REFERENCES public.users(id);


--
-- Name: reservation reservation_id_book_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_id_book_fkey FOREIGN KEY (id_book) REFERENCES public.book(id);


--
-- PostgreSQL database dump complete
--

