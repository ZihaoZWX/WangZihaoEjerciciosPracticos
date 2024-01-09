
package ejercicio1jas2d3.models;

import java.util.List;

/**
 *
 * @author Zihao Wang
 */
public class Directory {
    
    int id;
    private String name;
    List<Directory> subdirectory;
    List<String> files;
    
    public Directory(){
        
    }
    
    public Directory(String name,List<Directory> subdirectory){
        this.name = name;
        this.subdirectory=subdirectory;
    }

    public Directory(int id, String name, List<String> files) {
        this.id=id;
        this.name = name;
        this.files = files;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Directory> getSubdirectory() {
        return subdirectory;
    }

    public void setSubdirectory(List<Directory> subdirectory) {
        this.subdirectory = subdirectory;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Directory{" + "id=" + id + ", name=" + name + ", subdirectory=" + subdirectory + ", files=" + files + '}'+"\n";
    }

}
