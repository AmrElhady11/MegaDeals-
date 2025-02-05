
create database if not exists amazon_El8alaba_db;
use amazon_El8alaba_db;

create Table users
(
    id                integer    primary key   auto_increment,
    firstname         varchar(60)              not null,
    lastname          varchar(60)              null,
    username          varchar(60) unique       not null,
    email             varchar(60) unique       not null,
    password          varchar(60)              not null,
    role              enum('ADMIN','SELLER','CUSTOMER')                          default 'CUSTOMER',
    creation_time     timestamp                                                  default now(),
    last_updated_time timestamp                                                  default now()
);
create Table admins
(
    id                  integer    primary key   auto_increment,
    name                varchar(255),
    permissions         enum('MANAGER','OWNER'),
    last_login_time     timestamp,
    user_id             int,
    CONSTRAINT FK_UserAdmin  FOREIGN KEY (user_id) REFERENCES users(id)
);
create Table sellers
(
    id                  integer    primary key   auto_increment,
    name                varchar(255),
    description         text,
    phone_number        varchar(50),
    rating              double                              default  0.0,
    user_id             int,
    CONSTRAINT FK_UserSeller  FOREIGN KEY (user_id) REFERENCES users(id)
);
create Table customers
(
    id                        integer    primary key   auto_increment,
    name                varchar(255),
    phone_number              varchar(50),
    total_orders              int                            default  0,
    total_delivered_orders    int                            default  0,
    user_id                   int,
    CONSTRAINT FK_UserCustomer  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE Table products (
                          id                integer       primary key auto_increment,
                          name              varchar(60)               not null,
                          manufacturer      varchar(60) ,
                          production_date   date,
                          expiration_date   date  ,
                          unit_price        double,
                          stock_quantity    integer ,
                          availability      bool  ,
                          creation_time     timestamp ,
                          last_updated_time timestamp ,
                          seller_id         int       ,
                          status           enum('PENDING','APPROVED','REJECTED')         DEFAULT 'PENDING',
                          approved_by       int,
                          CONSTRAINT        FK_ProductSeller  FOREIGN KEY (seller_id) REFERENCES sellers(id),
                          CONSTRAINT        FK_ProductAdmin   FOREIGN KEY (approved_by) REFERENCES admins(id)


);


CREATE Table cart
(
    id                integer      primary key auto_increment,
    total_price       double,
    total_products     integer,
    discount          double,
    creation_time     timestamp,
    last_updated_time timestamp,
    user_id           integer,
    CONSTRAINT FK_UserCart  FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE Table cart_item
(
    id                 integer       primary key auto_increment,
    quantity           integer ,
    unit_price         double,
    total_price        integer,
    product_id         integer,
    Cart_id            integer,
    CONSTRAINT FK_Product_CartItem  FOREIGN KEY (product_id) REFERENCES products(id),
    CONSTRAINT FK_Cart_CartItem  FOREIGN KEY (Cart_id) REFERENCES cart(id)

);
CREATE Table orders
(
    id                integer       PRIMARY KEY auto_increment,
    total_price       double,
    order_time        timestamp,
    cart_id           integer,
    user_id           integer,
    CONSTRAINT FK_Cart_Orders  FOREIGN KEY (cart_id) REFERENCES cart(id),
    CONSTRAINT FK_User_Orders  FOREIGN KEY (user_id) REFERENCES users(id)
);
