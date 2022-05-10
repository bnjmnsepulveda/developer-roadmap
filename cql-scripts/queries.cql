
// labels web, mobile, security, cloud, theory, framework
// nodes: dev_role, language, knowledge 
// relationships dev-role -> languaje_to_domain | next_to_learn 


MATCH (n) DETACH DELETE n;

CREATE (DevRole:roadmap:fullstack { name: "fullstack javascript" }) RETURN DevRole;
CREATE (Knowledge:web:technical:frontend { name: "html css" }) RETURN Knowledge;
CREATE (Language:javascript:technical:frontend:backend { name: "javascript" }) RETURN Language;
CREATE (Language:typescript:technical:frontend:backend { name: "typescript" }) RETURN Language;
CREATE (Knowledge:web:theory:frontend:backend { name: "internet and web apps" }) RETURN Knowledge;
CREATE (Knowledge:basic:technical { name: "programming" }) RETURN Knowledge;
CREATE (Knowledge:basic:technical { name: "POO" }) RETURN Knowledge;
CREATE (Knowledge:database:technical:backend { name: "databases sql" }) RETURN Knowledge;
CREATE (Knowledge:database:technical:backend { name: "databases no-sql" }) RETURN Knowledge;
CREATE (Knowledge:os:technical:backend { name: "linux" }) RETURN Knowledge;
CREATE (Knowledge:software_engineering:technical { name: "software patterns" }) RETURN Knowledge;
CREATE (Knowledge:technical { name: "git" }) RETURN Knowledge;
CREATE (Framework:nestjs:web:technical:framework:backend { name: "nestjs" }) RETURN Framework;
CREATE (Framework:react:web:technical:framework:frontend { name: "react" }) RETURN Framework;

MATCH (a:roadmap), (b:web) 
   WHERE a.name = "fullstack javascript" AND b.name = "internet and web apps" 
CREATE (a)-[r:KWNOLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:web), (b:web) 
   WHERE a.name = "internet and web apps" AND b.name = "html css" 
CREATE (a)-[r:KWNOLDEGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:web), (b:javascript) 
   WHERE a.name = "html css" AND b.name = "javascript" 
CREATE (a)-[r:LANGUAGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:technical), (b:technical) 
   WHERE a.name = "javascript" AND b.name = "react" 
CREATE (a)-[r:FRAMEWORK_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:technical), (b:technical) 
   WHERE a.name = "javascript" AND b.name = "typescript" 
CREATE (a)-[r:LANGUAGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:roadmap), (b:basic) 
   WHERE a.name = "fullstack javascript" AND b.name = "programming" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:basic), (b:theory) 
   WHERE a.name = "programming" AND b.name = "software patterns" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:basic), (b:technical) 
   WHERE a.name = "programming" AND b.name = "POO" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:typescript), (b:nestjs) 
   WHERE a.name = "typescript" AND b.name = "nestjs" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:roadmap), (b:os) 
   WHERE a.name = "fullstack javascript" AND b.name = "linux" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;