package dev.rohitahuja.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import dev.rohitahuja.post.Post;
import dev.rohitahuja.post.PostService;

@PageTitle("Posts")
@Route(value = "posts", layout = MainLayout.class)
class PostsView extends Div {

    public PostsView(PostService postService) {
        setHeightFull();
        Grid<Post> grid = new Grid<>(Post.class, false);
        grid.addColumn(Post::title).setHeader("Title");
        grid.addColumn(Post::summary).setHeader("Summary");
        grid.addColumn(Post::url).setHeader("URL");
        grid.addColumn(Post::datePublished).setHeader("Date Published");
        grid.addColumn(p->p.author().name()).setHeader("Author");
        grid.addThemeVariants(GridVariant.LUMO_COMPACT);
        grid.setHeightFull();

        grid.setItems(postService.findAll());

        add(grid);
    }

}
