MATCH (n) DETACH DELETE n;

CREATE (DevRole:fullstack { name: "fullstack javascript" }) RETURN DevRole;
CREATE (DevRole:backend { name: "backend" }) RETURN DevRole;
CREATE (DevRole:frontend { name: "frontend" }) RETURN DevRole;
CREATE (Knowledge:technical { name: "html css javascript" }) RETURN Knowledge;
CREATE (Language:javascript:technical { name: "javascript" }) RETURN Language;
CREATE (Language:typescript:technical { name: "typescript" }) RETURN Language;
CREATE (Knowledge:web:theory { name: "internet and web apps" }) RETURN Knowledge;
CREATE (Knowledge:os:technical { name: "linux" }) RETURN Knowledge;
CREATE (Knowledge:software_engineering:technical { name: "software patterns" }) RETURN Knowledge;
CREATE (Knowledge:technical { name: "git" }) RETURN Knowledge;
CREATE (Framework:nestjs:web:technical { name: "nestjs" }) RETURN Framework;
CREATE (Framework:react:web:technical { name: "react" }) RETURN Framework;

MATCH (n) RETURN n;

MATCH (a:fullstack), (b:javascript) 
   WHERE a.name = "fullstack javascript" AND b.name = "javascript" 
CREATE (a)-[r:LANGUAGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:fullstack), (b:javascript) 
   WHERE a.name = "fullstack javascript" AND b.name = "typescript" 
CREATE (a)-[r:LANGUAGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:fullstack), (b:theory) 
   WHERE a.name = "fullstack javascript" AND b.name = "internet and web apps" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:theory), (b:backend) 
   WHERE a.name = "internet and web apps" AND b.name = "backend" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:theory), (b:frontend) 
   WHERE a.name = "internet and web apps" AND b.name = "frontend" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:frontend), (b:technical) 
   WHERE a.name = "frontend" AND b.name = "html css javascript" 
CREATE (a)-[r:KNOWLEDGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:technical), (b:technical) 
   WHERE a.name = "html css javascript" AND b.name = "react" 
CREATE (a)-[r:FRAMEWORK_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:backend), (b:typescript) 
   WHERE a.name = "backend" AND b.name = "typescript" 
CREATE (a)-[r:LANGUAGE_TO_DOMAIN]->(b) 
RETURN a,b;

MATCH (a:typescript), (b:nestjs) 
   WHERE a.name = "typescript" AND b.name = "nestjs" 
CREATE (a)-[r:FRAMEWORK_TO_DOMAIN]->(b) 
RETURN a,b;