package hello;

import com.google.gson.Gson;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NodeEntity
public class Meme {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    private String imageUrl;

    private Float score;

    private String uploadedBy;

    private Meme() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public Meme(String type, String imageUrl, Float score, String uploadedBy) {
        this.type = type;
        this.imageUrl = imageUrl;
        this.score = score;
        this.uploadedBy = uploadedBy;
    }
    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
//    @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
//    public Set<Meme> teammates;
//
//    public void worksWith(Meme person) {
//        if (teammates == null) {
//            teammates = new HashSet<>();
//        }
//        teammates.add(person);
//    }
}