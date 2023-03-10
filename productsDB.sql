PGDMP     8            	        {         
   productsDB    15.1    15.1 %               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    18858 
   productsDB    DATABASE     ?   CREATE DATABASE "productsDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "productsDB";
                postgres    false            ?            1259    18972 	   check_out    TABLE     &  CREATE TABLE public.check_out (
    check_out_id integer NOT NULL,
    product_id integer NOT NULL,
    user_id integer,
    product_name character varying(255) NOT NULL,
    price double precision NOT NULL,
    product_quantity integer NOT NULL,
    product_total double precision NOT NULL
);
    DROP TABLE public.check_out;
       public         heap    postgres    false            ?            1259    18971    check_out_check_out_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.check_out_check_out_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.check_out_check_out_id_seq;
       public          postgres    false    224                       0    0    check_out_check_out_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.check_out_check_out_id_seq OWNED BY public.check_out.check_out_id;
          public          postgres    false    223            ?            1259    18978    check_out_seq    SEQUENCE     w   CREATE SEQUENCE public.check_out_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.check_out_seq;
       public          postgres    false            ?            1259    18939    product_table    TABLE     ?   CREATE TABLE public.product_table (
    product_id integer NOT NULL,
    product_name character varying(255) NOT NULL,
    price double precision NOT NULL,
    quantity integer NOT NULL,
    user_id integer
);
 !   DROP TABLE public.product_table;
       public         heap    postgres    false            ?            1259    18938    product_table_product_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.product_table_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.product_table_product_id_seq;
       public          postgres    false    222                       0    0    product_table_product_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.product_table_product_id_seq OWNED BY public.product_table.product_id;
          public          postgres    false    221            ?            1259    18879    product_table_seq    SEQUENCE     {   CREATE SEQUENCE public.product_table_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.product_table_seq;
       public          postgres    false            ?            1259    18870    producttable_prouductid_seq    SEQUENCE     ?   CREATE SEQUENCE public.producttable_prouductid_seq
    AS integer
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.producttable_prouductid_seq;
       public          postgres    false            ?            1259    18930 
   user_table    TABLE     ?   CREATE TABLE public.user_table (
    user_id integer NOT NULL,
    user_name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(255) NOT NULL
);
    DROP TABLE public.user_table;
       public         heap    postgres    false            ?            1259    18868    user_table_id_seq    SEQUENCE     {   CREATE SEQUENCE public.user_table_id_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.user_table_id_seq;
       public          postgres    false            ?            1259    18929    user_table_product_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.user_table_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.user_table_product_id_seq;
       public          postgres    false    220                        0    0    user_table_product_id_seq    SEQUENCE OWNED BY     T   ALTER SEQUENCE public.user_table_product_id_seq OWNED BY public.user_table.user_id;
          public          postgres    false    219            ?            1259    18884    user_table_seq    SEQUENCE     x   CREATE SEQUENCE public.user_table_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.user_table_seq;
       public          postgres    false            ?            1259    18859    usertable_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.usertable_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.usertable_id_seq;
       public          postgres    false            w           2604    18975    check_out check_out_id    DEFAULT     ?   ALTER TABLE ONLY public.check_out ALTER COLUMN check_out_id SET DEFAULT nextval('public.check_out_check_out_id_seq'::regclass);
 E   ALTER TABLE public.check_out ALTER COLUMN check_out_id DROP DEFAULT;
       public          postgres    false    223    224    224            v           2604    18942    product_table product_id    DEFAULT     ?   ALTER TABLE ONLY public.product_table ALTER COLUMN product_id SET DEFAULT nextval('public.product_table_product_id_seq'::regclass);
 G   ALTER TABLE public.product_table ALTER COLUMN product_id DROP DEFAULT;
       public          postgres    false    221    222    222            u           2604    18933    user_table user_id    DEFAULT     {   ALTER TABLE ONLY public.user_table ALTER COLUMN user_id SET DEFAULT nextval('public.user_table_product_id_seq'::regclass);
 A   ALTER TABLE public.user_table ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    220    219    220                      0    18972 	   check_out 
   TABLE DATA           |   COPY public.check_out (check_out_id, product_id, user_id, product_name, price, product_quantity, product_total) FROM stdin;
    public          postgres    false    224   )                 0    18939    product_table 
   TABLE DATA           [   COPY public.product_table (product_id, product_name, price, quantity, user_id) FROM stdin;
    public          postgres    false    222   =)                 0    18930 
   user_table 
   TABLE DATA           H   COPY public.user_table (user_id, user_name, password, role) FROM stdin;
    public          postgres    false    220   ?)       !           0    0    check_out_check_out_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.check_out_check_out_id_seq', 1, false);
          public          postgres    false    223            "           0    0    check_out_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.check_out_seq', 4751, true);
          public          postgres    false    225            #           0    0    product_table_product_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.product_table_product_id_seq', 1, true);
          public          postgres    false    221            $           0    0    product_table_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.product_table_seq', 1953, true);
          public          postgres    false    217            %           0    0    producttable_prouductid_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.producttable_prouductid_seq', 1, false);
          public          postgres    false    216            &           0    0    user_table_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.user_table_id_seq', 1, false);
          public          postgres    false    215            '           0    0    user_table_product_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.user_table_product_id_seq', 1, false);
          public          postgres    false    219            (           0    0    user_table_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_table_seq', 1351, true);
          public          postgres    false    218            )           0    0    usertable_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.usertable_id_seq', 1, false);
          public          postgres    false    214            }           2606    18977    check_out check_out_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.check_out
    ADD CONSTRAINT check_out_pkey PRIMARY KEY (check_out_id);
 B   ALTER TABLE ONLY public.check_out DROP CONSTRAINT check_out_pkey;
       public            postgres    false    224            {           2606    18946     product_table product_table_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.product_table
    ADD CONSTRAINT product_table_pkey PRIMARY KEY (product_id);
 J   ALTER TABLE ONLY public.product_table DROP CONSTRAINT product_table_pkey;
       public            postgres    false    222            y           2606    18937    user_table user_table_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.user_table
    ADD CONSTRAINT user_table_pkey PRIMARY KEY (user_id);
 D   ALTER TABLE ONLY public.user_table DROP CONSTRAINT user_table_pkey;
       public            postgres    false    220               *   x?3170?4?40?44???sJsS?9M??? ?+F??? ?)?         <   x?3?40?,??)?MU0?456?42?4425?2?40?ɘ@d?2?0c???)D&F??? ??         H   x?3425??NL/?L?????????SsrR????8=?32???K?K?s!?ƜI9?yن?F???qqq ???     