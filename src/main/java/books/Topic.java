/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author thesh
 */
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String _key;
    private final String _title;
    private final String _outcome;
    private final String _info;
    private final String _imageEnabled;
    private final String _imageDisabled;
    private boolean _isEnabled;

    private Topic(String key, String title, String outcome,
            String info, String imageEnabled,
            String imageDisabled, boolean isEnabled) {
        _key = key;
        _title = title;
        _outcome = outcome;
        _info = info;
        _imageEnabled = imageEnabled;
        _imageDisabled = imageDisabled;
        _isEnabled = isEnabled;
    }

    public boolean isIsEnabled() {
        return _isEnabled;
    }

    public void setIsEnabled(boolean _isEnabled) {
        this._isEnabled = _isEnabled;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getKey() {
        return _key;
    }

    public String getTitle() {
        return _title;
    }

    public String getOutcome() {
        return _outcome;
    }

    public String getInfo() {
        return _info;
    }

    public String getImageEnabled() {
        return _imageEnabled;
    }

    public String getImageDisabled() {
        return _imageDisabled;
    }

    public String getImageImage() {
        return _isEnabled ? _imageEnabled : _imageDisabled;
    }

    public boolean isEnabled() {
        return _isEnabled;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this._key);
        hash = 29 * hash + Objects.hashCode(this._title);
        hash = 29 * hash + Objects.hashCode(this._outcome);
        hash = 29 * hash + Objects.hashCode(this._info);
        hash = 29 * hash + Objects.hashCode(this._imageEnabled);
        hash = 29 * hash + Objects.hashCode(this._imageDisabled);
        hash = 29 * hash + (this._isEnabled ? 1 : 0);
        return hash;
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
        final Topic other = (Topic) obj;
        if (this._isEnabled != other._isEnabled) {
            return false;
        }
        if (!Objects.equals(this._key, other._key)) {
            return false;
        }
        if (!Objects.equals(this._title, other._title)) {
            return false;
        }
        if (!Objects.equals(this._outcome, other._outcome)) {
            return false;
        }
        if (!Objects.equals(this._info, other._info)) {
            return false;
        }
        if (!Objects.equals(this._imageEnabled, other._imageEnabled)) {
            return false;
        }
        if (!Objects.equals(this._imageDisabled, other._imageDisabled)) {
            return false;
        }
        return true;
    }

    public static class TopicBuilder {

        private final String _key;
        private String _title = "";
        private String _outcome = "";
        private String _info = "";
        private String _imageEnabled = "";
        private String _imageDisabled = "";
        private boolean _isEnabled = true;

        static public TopicBuilder createBuilder(String key) {
            return new TopicBuilder(key);
        }

        private TopicBuilder(String key) {
            _key = key;
            _title = key;   // defaults to key
        }

        public TopicBuilder setTitle(String title) {
            _title = title;
            return this;
        }

        public TopicBuilder setOutcome(String outcome) {
            _outcome = outcome;
            return this;
        }

        public TopicBuilder setInfo(String info) {
            _info = info;
            return this;
        }

        public TopicBuilder setImageEnabled(String imageEnabled) {
            _imageEnabled = imageEnabled;
            return this;
        }

        public TopicBuilder setEnabled(boolean enabled) {
            _isEnabled = enabled;
            return this;
        }

        public Topic build() {
            return new Topic(_key, _title, _outcome, _info, _imageEnabled, _imageDisabled, _isEnabled);
        }

    }

}
