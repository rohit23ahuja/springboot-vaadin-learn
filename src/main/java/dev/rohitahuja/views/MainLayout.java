package dev.rohitahuja.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE);

        addToNavbar(false, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Interactions");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.Vertical.MEDIUM,
                LumoUtility.Margin.Horizontal.MEDIUM);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();
        nav.addClassNames(LumoUtility.Margin.SMALL, LumoUtility.Margin.Top.NONE);

        nav.addItem(new SideNavItem("About", AboutView.class, LineAwesomeIcon.QUESTION_CIRCLE.create()));
        nav.addItem(new SideNavItem("Posts", PostsView.class, LineAwesomeIcon.COMMENTS.create()));
        nav.addItem(new SideNavItem("Main", MainView.class, LineAwesomeIcon.AIRBNB.create()));
        nav.addItem(new SideNavItem("Knowledge Search", KnowledgeSearchView.class, LineAwesomeIcon.IMAGE.create()));
        nav.addItem(new SideNavItem("Chat", ChatView.class, LineAwesomeIcon.ADDRESS_BOOK.create()));
        nav.addItem(new SideNavItem("Ingestion", IngestionView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("Tools", ToolsView.class, LineAwesomeIcon.SCREWDRIVER_SOLID.create()));
        nav.addItem(new SideNavItem("MCP", McpView.class, LineAwesomeIcon.WRENCH_SOLID.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
