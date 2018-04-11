package model;

import java.util.ArrayList;
import java.util.List;

public class PostService implements Service<Post>{
    private List<Post> posts = new ArrayList<Post>();

    @Override
    public List<Post> get() {
        return posts;
    }

    @Override
    public Post get(long id) {
        for(int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == id) {
                return posts.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean add(Post entity) {
        return posts.add(entity);
    }

    @Override
    public boolean delete(long id) {
        for(int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == id) {
                return posts.remove(i) != null;
            }
        }
        return false;
    }

    @Override
    public boolean edit(long id, Post entity) {
        for(int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == id) {
                Post p = posts.get(i);

                p.setPost(entity.getPost());
                return true;
            }
        }
        return false;
    }
}
