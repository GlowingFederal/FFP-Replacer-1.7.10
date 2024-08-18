import os
import re

# File Inputs
csv_file = 'FFPMappings.csv'
java_directory = './java_files/'  # Directory containing .java files
output_directory = './updated_files/'  # Directory to save updated .java files

# Make Dict
mapping = {}

with open(csv_file, 'r') as file:
    for line in file:
        parts = line.strip().split(',')
        if len(parts) == 2:
            old_name, new_name = parts
            mapping[old_name] = new_name

# Ensure output directory exists
if not os.path.exists(output_directory):
    os.makedirs(output_directory)

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

# Process the .java files
for java_file in os.listdir(java_directory):
    if java_file.endswith('.java'):
        input_file_path = os.path.join(java_directory, java_file)
        output_file_path = os.path.join(output_directory, java_file)

        with open(input_file_path, 'r') as file:
            java_code = file.read()

        # Update code
        updated_code = java_code
        for pattern, type_prefix in patterns:
            updated_code = pattern.sub(replace_names, updated_code)

        # Write updated code to file
        with open(output_file_path, 'w') as file:
            file.write(updated_code)

        # Print replacement counts for double-checking
        print(f"Processed {java_file}:")
        print(f"func_: {replacement_counts['func_']}")
        print(f"field_: {replacement_counts['field_']}")
        print(f"p_: {replacement_counts['p_']}")
        print(f"Updated Java source code saved as {output_file_path}")
