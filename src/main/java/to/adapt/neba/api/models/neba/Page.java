package to.adapt.neba.api.models.neba;

import io.neba.api.annotations.Children;
import io.neba.api.annotations.Path;
import io.neba.api.annotations.ResourceModel;
import io.neba.api.annotations.This;
import org.apache.sling.api.resource.Resource;
import to.adapt.neba.api.models.spring.Section;

import java.util.List;

/**
 * Models a page resource types, demonstrates mapping child resources using NEBA.
 */
@ResourceModel("neba-sample/components/page")
public class Page {
    /**
     * Since this field has a type that cannot be mapped from a resource property,
     * NEBA will attempt to resolve a child resource named like this field ("header") and adapt it to
     * the field's type, i.e. to {@link Header}. The way the header is looked up can, for instance, be
     * altered using the {@link io.neba.api.annotations.Path} annotation.
     */
    private Header header;

    /**
     * {@link This} conveniently injects the resource adapted to the current model.
     */
    @This
    private Resource resource;

    /**
     * Loads the child resources of [this resource path]/section and adapts them to {@link Section}.
     * This collection is automatically lazy-loading, i.e. the sections will be loaded from the repository
     * when a method of the sections collection is invoked.
     */
    @Path("sections")
    @Children
    private List<Section> sections;

    public Header getHeader() {
        return header;
    }

    public String getPath() {
        return resource.getPath();
    }

    public Resource getResource() {
        return resource;
    }

    public List<Section> getSections() {
        return sections;
    }
}
