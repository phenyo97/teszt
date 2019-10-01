#include "filesystem.h"

void Filesystem::printUserandLocation()
{
	cout << user;
	for (auto& dir : currentLocation) {
		cout << dir->getName();
	}
	cout << "\n$ ";
}

void Filesystem::run()
{
	string input;
	while (true) {
		printUserandLocation();
		getline(cin, input);
		if (input == "exit") return;
		runCommand(input);
	}
}

void Filesystem::runCommand(string line)
{
	stringstream ss(line);
	string command;
	ss >> command;

	if (command.empty())
		return;
	else if (command == "mkdir") {
		this->mkdir(ss);
	}
	else if (command == "touch") {
		this->touch(ss);
	}
	else if (command == "cd") {
		this->cd(ss);
	}
	else if (command == "ls") {
		currentDirectory->ls();
	}
	else if (command == "treelist") {
		root->treelist(0);
	}
	else if (command == "rm"){
		this->rm(ss);
	}
	else {
		cout << "Wrong command!"<<endl;
		return;
	}
}

void Filesystem::mkdir(stringstream &ss)
{
	string name;
	ss >> name;

	if (!currentDirectory->mkdir(new Directory(name))){
        cout << "Directory already exists\n";
   	 }

}

void Filesystem::touch(stringstream &ss)
{
	string name;
	ss >> name;
	string content;
	while (ss >> content) {
		;
	}

	if (!currentDirectory->touch(new File(name, content))) {
		cout << "File already exists\n";
	}
}

void Filesystem::cd(stringstream &ss)
{
	string directoryName;
	ss >> directoryName;

	if (directoryName.empty()) {
		this->cdParent();
		return;
	}

	if (directoryName == "..") {
		this->cdRoot();
		return;
	}

    if(!this->cdToDirectory(currentDirectory->contains(directoryName))){
		cout << "Directory Not Found\n";
	}
}

void Filesystem::cdRoot()
{
	if(currentDirectory->getNameRaw() == "~"){
		return;
	}
	currentLocation.pop_back();
	currentDirectory = currentLocation.back();
	return;
}

void Filesystem::cdParent()
{
	currentLocation = vector<Directory*>{};
	currentLocation.push_back(root);
	currentDirectory = root;
}

bool Filesystem::cdToDirectory(Directory* newLocation)
{
    if (newLocation) {
		currentDirectory = newLocation;
		currentLocation.push_back(newLocation);
		return true;
	}
	return false;
}

void Filesystem::rm(stringstream &ss)
{
	string arg1;
	ss >> arg1;
	if(arg1.empty()){
		return;
	}

	if(arg1 == "-rf"){
		//cerr << "called RM RF \n";
		string dirName;
		ss >> dirName;
		
		if(dirName.empty()){
			return;
		}

		Directory* dirToDelete = currentDirectory->contains(dirName);
		if(dirToDelete){
			dirToDelete->rm();
			currentDirectory->deleteDirectory(dirToDelete->getNameRaw());
		}
		return;
	}

	//cerr << "Called RM\n";
	File* fileToDelete = currentDirectory->containsFile(arg1);
	Directory* dirToDelete = currentDirectory->contains(arg1);
	if(dirToDelete){
		cerr << "Cannot remove: '" << dirToDelete->getNameRaw() << "' it is a directory\n";
		return;
	}
	if(!fileToDelete){
		cerr << "File does not exist\n";
		return;
	} 
	currentDirectory->deleteFile(fileToDelete->getName());
}
