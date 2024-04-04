package com.justdo.plug.post.domain.category.service;

import com.justdo.plug.post.domain.category.Category;
import com.justdo.plug.post.domain.category.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void createCategory(String name, Long post_id){
        Category category = new Category();
        category.setPost_id(post_id);
        category.setName(name);
        save(category);
    }
    public void save(Category category){
        categoryRepository.save(category);
    }
}
