
run:
	mvn spring-boot:run

merge-2-master-and-delete-branch:
	git checkout master
	git merge $(b)
	git branch -d $(b)