package ma.sfifa.service.impl;

import org.springframework.stereotype.Service;

import ma.sfifa.repository.CategoryRepository;

@Service
public class CategoryService implements ma.sfifa.service.CategoryService{

	private CategoryRepository categoryRepository;
}
