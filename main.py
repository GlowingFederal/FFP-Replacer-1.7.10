import re

# File Inputs
csv_file = 'FFPMappings.csv'
java_file = 'input.java'
output_file = 'Output.java'

# Make Dict
mapping = {}


with open(csv_file, 'r') as file:
    for line in file:
        parts = line.strip().split(',')
        if len(parts) == 2:
            old_name, new_name = parts
            mapping[old_name] = new_name


with open(java_file, 'r') as file:
    java_code = file.read()


replacement_counts = {
    'func_': 0,
    'field_': 0,
    'p_': 0
}

# Replace func
def replace_names(match):
    full_match = match.group(0)
    name_body = match.group(1)


    if name_body in mapping:
        new_name = mapping[name_body]
        replacement_type = name_body.split('_')[0] + '_'
        replacement_counts[replacement_type] += 1
        return new_name
    return full_match


patterns = [
    (re.compile(r'\b(func_\w+)\b'), 'func_'),
    (re.compile(r'\b(field_\w+)\b'), 'field_'),
    (re.compile(r'\b(p_\w+)\b'), 'p_')
]

# Update code
updated_code = java_code
for pattern, type_prefix in patterns:
    updated_code = pattern.sub(replace_names, updated_code)

# Write updated code to file
with open(output_file, 'w') as file:
    file.write(updated_code)

# Print replacement counts for double checking
print(f"Updated Java source code saved as {output_file}")
print(f"Replacements made:")
print(f"func_: {replacement_counts['func_']}")
print(f"field_: {replacement_counts['field_']}")
print(f"p_: {replacement_counts['p_']}")
