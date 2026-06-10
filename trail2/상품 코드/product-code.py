product_name, product_code = input().split()
product_code = int(product_code)

# Please write your code here.
class product :
    def __init__(self, name, code) :
        self.name = name
        self.code = code


product1 = product("codetree", 50)
product2 = product(product_name, product_code)

print(f"product {product1.code} is {product1.name}")
print(f"product {product2.code} is {product2.name}")