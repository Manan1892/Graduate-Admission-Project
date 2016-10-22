   create table Academic_rec (
        acarec int4 not null,
        gpa float8,
        transcript varchar(255),
        application_applicant_id int4,
        primary key (acarec)
    );

    create table Add_Field (
        addfld int4 not null,
        nameoffield varchar(255),
        optionalfield varchar(255),
        requiredfield varchar(255),
        typeoffield varchar(255),
        application_applicant_id int4,
        department_department_id int4,
        primary key (addfld)
    );

    create table Applicantstatus (
        applicant_status int4 not null,
        comments varchar(255),
        date varchar(255),
        status varchar(255),
        application_applicant_id int4,
        primary key (applicant_status)
    );

    create table Application (
        applicant_id int4 not null,
        birthdate varchar(255),
        cin varchar(255),
        citizenship varchar(255),
        emailid varchar(255),
        firstname varchar(255),
        gender varchar(255),
        lasttname varchar(255),
        phoneno varchar(255),
        term varchar(255),
        addfield_addfld int4,
        applicationstatus_applicant_status int4,
        department_department_id int4,
        programs_program_id int4,
        record_acarec int4,
        primary key (applicant_id)
    );

    create table Degree (
        degree_id int4 not null,
        clgname varchar(255),
        degreename varchar(255),
        application_applicant_id int4,
        primary key (degree_id)
    );

    create table Department (
        department_id int4 not null,
        departmentname varchar(255),
        primary key (department_id)
    );

    create table Program_id (
        program_id int4 not null,
        programname varchar(255),
        department_department_id int4,
        primary key (program_id)
    );

    create table Users (
        user_id int4 not null,
        email varchar(255) not null,
        firstname varchar(255) not null,
        lastname varchar(255) not null,
        password varchar(255) not null,
        username varchar(255),
        typeuser_type_id int4,
        primary key (user_id)
    );

    create table usertoapplicant (
        user_id int4 not null,
        applicant_id int4 not null
    );

    create table usertype (
        type_id int4 not null,
        type varchar(255),
        primary key (type_id)
    );

    alter table Academic_rec 
        add constraint FK_qoeg243k23xn03vg0x2hmefbl 
        foreign key (application_applicant_id) 
        references Application;

    alter table Add_Field 
        add constraint FK_mxjdio0rkd8uagtv4eypqxon4 
        foreign key (application_applicant_id) 
        references Application;

    alter table Add_Field 
        add constraint FK_aiaciiqfj4og4k05frfuqqsd2 
        foreign key (department_department_id) 
        references Department;

    alter table Applicantstatus 
        add constraint FK_o6pvmjcpuysevp25p7jtxtfdb 
        foreign key (application_applicant_id) 
        references Application;

    alter table Application 
        add constraint FK_1apicj5618ddntttaic3bkj7k 
        foreign key (addfield_addfld) 
        references Add_Field;

    alter table Application 
        add constraint FK_75v90kbumlicjvu4kw8tujn3a 
        foreign key (applicationstatus_applicant_status) 
        references Applicantstatus;

    alter table Application 
        add constraint FK_hbo0vppbe48s54u72emyhkshy 
        foreign key (department_department_id) 
        references Department;

    alter table Application 
        add constraint FK_qxsicg21awrf8hhy9c39ivxax 
        foreign key (programs_program_id) 
        references Program_id;

    alter table Application 
        add constraint FK_qjrwe897dnkd4j3t6c88lmdhq 
        foreign key (record_acarec) 
        references Academic_rec;

    alter table Degree 
        add constraint FK_j9baufekv5uuywwh4l4q1ecqe 
        foreign key (application_applicant_id) 
        references Application;

    alter table Program_id 
        add constraint FK_icmsmbe3egkaefwtjm6b8a7yi 
        foreign key (department_department_id) 
        references Department;

    alter table Users 
        add constraint FK_dc54lpeqab9knbpgh1pvbxmuj 
        foreign key (typeuser_type_id) 
        references usertype;

    alter table usertoapplicant 
        add constraint FK_nlc9fdn1xo2hcq48vkm2wb9tt 
        foreign key (applicant_id) 
        references Application;

    alter table usertoapplicant 
        add constraint FK_oonfl9bnt7r0cikqfg21knx0s 
        foreign key (user_id) 
        references Users;

    create sequence hibernate_sequence;