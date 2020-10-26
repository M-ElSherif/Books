/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

/**
 *
 * @author thesh
 */
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catId")
    private int _id = -1;
    @Column(name = "catName")
    private String _name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ctCategoryId", referencedColumnName = "catId")
    @MapKey(name = "_language")
    private Map<String, CategoryTranslation> _catTranslations = new HashMap<>();

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public Map<String, CategoryTranslation> getCategoryTranslations() {
        return _catTranslations;
    }

    public void setCategoryTranslations(Map<String, CategoryTranslation> catTranslations) {
        this._catTranslations = catTranslations;
    }

    public String getTranslatedName(String langCode) {
        if (_catTranslations.containsKey(langCode)) {
            return _catTranslations.get(langCode).getName();
        }
        return "";
    }

    public void setTranslatedName(String langCode, String name) {
        if (_catTranslations.containsKey(langCode)) {
            _catTranslations.get(langCode).setName(name);
        } else {
            CategoryTranslation translation = new CategoryTranslation();
            translation.setLanguage(langCode);
            translation.setCategoryId(_id);
            translation.setName(name);
            _catTranslations.put(langCode, translation);
        }
    }

    public String getTranslatedNameOrDefault(String langCode) {
        if (_catTranslations.containsKey(langCode)) {
            String name = _catTranslations.get(langCode).getName();
            if (name.isEmpty()) {
                return _name;
            }
            return name;
        }
        return _name;
    }

    @Override
    public int hashCode() {
        if (this._id < 0) {
            return _name.hashCode();
        }
        return _id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (this._id != other._id) {
            return false;
        }
        if (!Objects.equals(this._name, other._name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Category[ id=" + _id + "]" + _name;
    }
}
