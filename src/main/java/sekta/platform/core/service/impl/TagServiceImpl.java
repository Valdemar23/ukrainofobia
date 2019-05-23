package sekta.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sekta.platform.core.dao.TagDao;
import sekta.platform.core.entity.Tag;
import sekta.platform.core.service.TagService;

import java.util.List;

/**
 * Created by natad on 29.05.2016.
 */
@Service
public class TagServiceImpl implements TagService {//realisation interface CRUD
    @Autowired
    TagDao tagDao;

    @Override
    public List<Tag> getAllTags() {
        return tagDao.findAll();
    }

    @Override
    public Tag getTagById(Long id) {
        return tagDao.getById(id);
    }

    @Override
    public Tag createTag(Tag tag) {
        tagDao.create(tag);
        return tag;
    }

    @Override
    public Tag updateTag(Tag tag) {
        tagDao.update(tag);
        return tag;
    }

    @Override
    public void deleteTag(Long tagId) {
        Tag tag = new Tag();
        tag.setId(tagId);
        tagDao.delete(tag);
    }
}
