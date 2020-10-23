/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author thesh
 */
public class Topics implements Serializable {

    private Optional<Topic> _activeTopic = Optional.empty();
    private final Set<Topic> _topics = new LinkedHashSet<>();

    public Set<Topic> getTopics() {
        return _topics;
    }

    public void clear() {
        _topics.clear();
    }

    public void addTopic(Topic topic) {
        _topics.add(topic);
    }

    public void addTopic(String title) {
        this.addTopic(Topic.TopicBuilder.createBuilder(title).build());
    }

    public void remove(Topic topic) {
        _topics.remove(topic);
    }

    // functional programming approach
    public Optional<Topic> findTopic(String key) {
        return _topics.stream()
                .filter(topic -> topic.getKey().equals(key))
                .findAny();
    }

    /*
    OR ALTERNATIVE PRE JAVA 8 code
    public Topic findTopic(String key) {
        for (Topic topic : this._topics) {
            if (topic.getKey().equals(key)) {
                return topic;
            }
        }
        return Topic.TopicBuilder.createBuilder("").build();
    }
     */
    public Optional<Topic> getActiveTopic() {
        return _activeTopic;
    }

    public void setActive(String key) {
        _activeTopic = findTopic(key);
    }
}
