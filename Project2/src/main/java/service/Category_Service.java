package service;

import model.Category;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class Category_Service {
    private ArrayList<Category> categoryList=new ArrayList<>();

    public ArrayList<Category> getCategory(){
        return categoryList;
    }
    public void addCategory(Category category){
        categoryList.add(category);
    }
    public void updateCategory(int index, Category category) {
        categoryList.set(index,category);
    }
    public void deleteCategory(int index) {
        categoryList.remove(index);
    }


}
