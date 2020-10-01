package com.pattern.factory;

/**
 * @author tania.gupta
 * @date 02/06/20
 */
public class Blog extends Website {

    @Override
    public void createWebsite() {
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new CommentPage());
        pages.add(new PostPage());
    }

}
