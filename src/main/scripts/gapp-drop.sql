
    alter table Academic_rec 
        drop constraint FK_qoeg243k23xn03vg0x2hmefbl;

    alter table Add_Field 
        drop constraint FK_mxjdio0rkd8uagtv4eypqxon4;

    alter table Add_Field 
        drop constraint FK_aiaciiqfj4og4k05frfuqqsd2;

    alter table Applicantstatus 
        drop constraint FK_o6pvmjcpuysevp25p7jtxtfdb;

    alter table Application 
        drop constraint FK_1apicj5618ddntttaic3bkj7k;

    alter table Application 
        drop constraint FK_75v90kbumlicjvu4kw8tujn3a;

    alter table Application 
        drop constraint FK_hbo0vppbe48s54u72emyhkshy;

    alter table Application 
        drop constraint FK_qxsicg21awrf8hhy9c39ivxax;

    alter table Application 
        drop constraint FK_qjrwe897dnkd4j3t6c88lmdhq;

    alter table Degree 
        drop constraint FK_j9baufekv5uuywwh4l4q1ecqe;

    alter table Program_id 
        drop constraint FK_icmsmbe3egkaefwtjm6b8a7yi;

    alter table Users 
        drop constraint FK_dc54lpeqab9knbpgh1pvbxmuj;

    alter table usertoapplicant 
        drop constraint FK_nlc9fdn1xo2hcq48vkm2wb9tt;

    alter table usertoapplicant 
        drop constraint FK_oonfl9bnt7r0cikqfg21knx0s;

    drop table if exists Academic_rec cascade;

    drop table if exists Add_Field cascade;

    drop table if exists Applicantstatus cascade;

    drop table if exists Application cascade;

    drop table if exists Degree cascade;

    drop table if exists Department cascade;

    drop table if exists Program_id cascade;

    drop table if exists Users cascade;

    drop table if exists usertoapplicant cascade;

    drop table if exists usertype cascade;

    drop sequence hibernate_sequence;
