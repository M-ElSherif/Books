package books.entities;

import books.entities.CategoryTranslation;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-10-26T18:03:59")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> _name;
    public static volatile MapAttribute<Category, String, CategoryTranslation> _catTranslations;
    public static volatile SingularAttribute<Category, Integer> _id;

}