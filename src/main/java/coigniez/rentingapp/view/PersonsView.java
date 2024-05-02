package coigniez.rentingapp.view;

import coigniez.rentingapp.model.entity.Person;
import coigniez.rentingapp.model.service.PersonService;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;


@Route("persons")
public class PersonsView extends VerticalLayout {

    public PersonsView(PersonService personService) {
        // grid
        GridCrud<Person> crud = new GridCrud<>(Person.class, new HorizontalSplitCrudLayout());

        // form
        crud.getCrudFormFactory().setVisibleProperties("firstName", "lastName", "birthDate");

        // additional components
        TextField filter = new TextField();
        filter.setPlaceholder("Filter by name");
        filter.setClearButtonVisible(true);
        crud.getCrudLayout().addFilterComponent(filter);
        filter.addValueChangeListener(e -> crud.refreshGrid());
        
        // grid settings
        crud.getGrid().setColumns("firstName", "lastName");
        crud.setCrudListener(personService);
        crud.setFindAllOperation(() -> personService.findByNameContainingIgnoreCase(filter.getValue()));

        add(crud);
        setSizeFull();
    }
}

    
