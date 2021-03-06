seiso
=====

[![Build Status](https://travis-ci.org/ExpediaDotCom/seiso.svg?branch=master)](https://travis-ci.org/ExpediaDotCom/seiso)

Devops data integration repository.

Please see the [seiso.io](http://seiso.io) for project information and documentation.

Dev setup
=========

There are two options available here. The first is a manual setup, where you install Java, MySQL, RabbitMQ and the app yourself. The other is via Vagrant.

Approach #1: Manual setup
-------------------------

**Installation.** You'll need to install the following:

* Java 8
* MySQL 5.6.x
  * Create the Seiso database: `create database seiso;`
  * Create a `seiso` user. It needs at least select, update and delete permissions on the `seiso` database.
  * Create the tables by running `src/main/sql/create-tables.sql`.
  * Insert the reference data by running `src/main/sql/insert-reference-data.sql`.
  * If you like, insert the sample data by running `src/main/sql/insert-sample-data.sql`.
* RabbitMQ
  * For visibility we recommend installing the RabbitMQ management plugin.

Approach #2: Vagrant setup
--------------------------

You can use [Vagrant](https://www.vagrantup.com/) to set up your development environment, which consists of a MySQL database and a RabbitMQ message bus.

As a preliminary, you will need to install the [Omnibus plugin](https://github.com/opscode/vagrant-omnibus), which will install the Chef provisioner on your VMs, then do

    $ vagrant up

to create your VMs. With respect to the database VM, this creates the database and sample user automatically, and it also inserts the reference and sample data automatically.

Note that it takes a little while to create VMs, so if you want to speed things up, you can open two terminal windows and do

    $ vagrant up db

in one and

    $ vagrant up bus

in the other, just to parallelize the work.

Common Configuration
-------------

Create a copy of `conf-sample/application.yml` and modify it as appropriate.

To run Seiso in development mode, you can place it directly in `src/main/resources`.

Patch the Database
-------------

* Connect to `localhost:3306/seiso` as `root` user
* Run any patch files.
* Follow the instructions in that patch sql file (e.g. Run query: `update person set source='ldap-corp'`)


Build Seiso
===========

    $ ./gradlew clean build

Run Seiso
=========

    $ ./gradlew bootRun

Point your HTML5-enabled browser to **https://localhost:8443** or whatever scheme/port combo you chose during configuration. You should see a home page with a list of services.
