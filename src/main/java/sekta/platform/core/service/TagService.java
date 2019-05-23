package sekta.platform.core.service;

import sekta.platform.core.entity.Tag;

import java.util.List;

/**
 * Created by natad on 29.05.2016.
 */
public interface TagService {//interface CRUD
    List<Tag> getAllTags();
    Tag getTagById(Long id);
    Tag createTag(Tag tag);
    Tag updateTag(Tag tag);
    void deleteTag(Long tagId);
}
