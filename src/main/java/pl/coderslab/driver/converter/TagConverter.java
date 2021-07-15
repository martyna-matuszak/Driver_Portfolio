package pl.coderslab.driver.converter;

import org.springframework.stereotype.Component;
import pl.coderslab.driver.dto.TagDto;
import pl.coderslab.driver.entity.Tag;

import java.util.ArrayList;
import java.util.List;

@Component
public class TagConverter {

    public TagDto tagToDto(Tag tag){
        TagDto tagDto = new TagDto();
        tagDto.setId(tag.getId());
        tagDto.setName(tag.getName());
        return tagDto;
    }

    public Tag dtoToTag(TagDto tagDto){
        Tag tag = new Tag();
        tag.setId(tagDto.getId());
        tag.setName(tagDto.getName());
        return tag;
    }

    public List<TagDto> tagsToDtos(List<Tag> tags){
        List<TagDto> tagDtos = new ArrayList<>();
        tags.forEach(tag -> tagDtos.add(tagToDto(tag)));
        return tagDtos;
    }

    public List<Tag> dtosToTags(List<TagDto> tagDtos){
        List<Tag> tags = new ArrayList<>();
        tagDtos.forEach(tagDto -> tags.add(dtoToTag(tagDto)));
        return tags;
    }
}
