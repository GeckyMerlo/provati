Before running this example:
1) Create a folder in your PC where you want the images to be saved (e.g. Users/fraternali/Documents/Images/tiw_project1) 
2) Modify the context param "outputpath" in your WEB.XML (this will be later used on the UploadImage servlet to save the images)
		Inside the WEB.XML modify the following code:
		<!-- You must create this folder inside your pc and then put here the absolute path! -->
		<context-param>
		    <param-name>outputpath</param-name>
		    <param-value>YOUR_PATH/TO/THE/IMAGES/FOLDER/</param-value>
		</context-param>
		
IMPORTANT: in this example the class CourseManager acts as a "mock-up" of the the database. 
As you advance in the course you will learn to create classes to write and read from the database, 
that will be the standard for the course.