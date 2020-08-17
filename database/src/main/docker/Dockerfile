FROM postgres:11-alpine
ADD bootstrap_db.sql      /docker-entrypoint-initdb.d/bootstrap_db.sql
RUN chmod +x /docker-entrypoint-initdb.d/bootstrap_db.sql
ADD license_data.csv      license_data.csv
ADD organization_data.csv /organization_data.csv
